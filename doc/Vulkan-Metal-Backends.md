# Plan : painters PanamaGL Vulkan et Metal (OpenGL hors OpenGL)

Statut : **plan + POC du niveau 1**.

Voir aussi [OpenGL-Ecosystem.md](OpenGL-Ecosystem.md) : les libs, les couches (GL, GLEXT, EGL, GLX, WGL, CGL, GLVND, DRI, Xvfb…) et la vue des technos supportées.

## 1. Constat de départ

### Ce que Jzy3D attend d'un painter

* Les drawables de Jzy3D n'appellent pas OpenGL directement : ils passent par `IPainter`
  (`jzy3d-core/.../painters/IPainter.java`, ~250 méthodes).
* La sémantique de `IPainter` est celle d'**OpenGL 1.x à pipeline fixe** :
  mode immédiat (`glBegin/glVertex/glEnd`), piles de matrices, lumières et matériaux,
  6 plans de clipping, display lists, stencil, polygon offset, line stipple, `glDrawPixels`,
  texte GLUT, et pour le picking **selection mode** (`PickingSupport`) et **feedback mode**
  (`FeedbackBufferAxisBox`).
* S'y ajoutent des méthodes optionnelles GL2+ (VBO, shaders, FBO, queries) utilisées par
  `DrawableVBO2`, `GLSLProgram` et le depth peeling. Elles lèvent `UnsupportedOperationException`
  par défaut.
* `PanamaGLPainter` (2 040 lignes) délègue tout cela à `panamagl.opengl.GL`
  (GL 1.0 → 4.6 + GLU + GLUT, ~1 000 fonctions). Les piles de matrices ne sont **pas** dans
  `AbstractPainter` : elles vivent dans le driver GL.
* **Précédent important** : `EmulGLPainter` implémente déjà `IPainter` sans OpenGL natif
  (sur jGL, en Java/CPU). Le contrat `IPainter` peut donc être servi par autre chose qu'OpenGL.

### Ce que PanamaGL apporte

* PanamaGL rend **toujours offscreen** : `FBO` → `glReadPixels` → image affichée par
  AWT/Swing/JavaFX/SWT.
* C'est un atout majeur pour Vulkan et Metal : **pas de swapchain, pas de surface native,
  pas d'intégration fenêtre**. Il suffit de rendre dans une image et de la relire, exactement
  comme aujourd'hui.
* Couplage à OpenGL : `PanamaGLFactory` (`GL`, `GLContext`, `FBO`, `OffscreenRenderer`),
  `GLEventListener(GL)`. Les modules UI référencent `GL` dans 13 fichiers sur 30
  (awt 7/14, swing 1/1, javafx 2/8, swt 3/7).

## 2. Trois niveaux pour faire « de l'OpenGL hors OpenGL »

| Niveau | Idée | Coût | Perf | Couverture |
|---|---|---|---|---|
| **1. GL‑sur‑X sous PanamaGL** | Garder `GL`, charger une implémentation OpenGL qui tourne sur Vulkan/Metal (Zink, ANGLE) | **faible** | ≈ natif | Linux, Windows : complète. macOS : expérimentale |
| **2. Painter natif Vulkan / Metal** | `VulkanPainter`/`MetalPainter` implémentent `IPainter` en émulant le pipeline fixe | **élevé** | bonne si batching | à reconstruire fonction par fonction |
| **3. Géométries multi‑backend** | Les drawables produisent des maillages + états, rendus par un backend GL/Vulkan/Metal/WebGPU | **élevé, mais progressif** | **meilleure** (GPU‑resident) | migration drawable par drawable |

### Recommandation

1. Faire le **niveau 1** tout de suite. Il est prouvé par le POC ci‑dessous et donne Vulkan
   sur Linux/Windows pour quelques jours de travail.
2. Ne **pas** écrire deux painters séparés (Vulkan puis Metal). Écrire **un** émulateur
   pipeline‑fixe en Java, indépendant du backend (niveau 2). Le brancher d'abord sur
   **OpenGL core profile** : c'est un gain immédiat sur macOS, limité aujourd'hui au contexte
   legacy 2.1. Le brancher ensuite sur **Vulkan**. Metal arrive par Vulkan‑sur‑Metal
   (KosmicKrisp ou MoltenVK) ; un backend Metal natif ne se justifie que si cela ne suffit pas.
3. Faire converger le niveau 2 vers le niveau 3 grâce à un `RecordingPainter`. Il enregistre les
   appels immédiats d'un drawable une fois pour toutes, sous forme de buffers GPU, ce qui
   règle le vrai problème de performance (un downcall FFM par `glVertex`).

## 3. Niveau 1 — GL‑sur‑Vulkan/Metal sous PanamaGL (POC fait)

### POC réalisé (Linux)

* `EGLContext_linux` : contexte OpenGL **headless** via EGL `surfaceless` (7 downcalls FFM
  écrits à la main, sans JExtract). Profil *compatibility* demandé.
* Sélection par `-Dpanamagl.linux.context=egl` dans `APanamaGLFactory_linux` ; GLX reste le
  défaut.
* `TestEGLContext_linux` : triangle en mode immédiat → `FBO_linux` → `readPixels` → pixels
  vérifiés.

Résultats (Mesa 25.2.8, lavapipe = Vulkan CPU, **sans serveur X**) :

```
EGL natif : 4.5 (Compatibility Profile) Mesa 25.2.8 / llvmpipe          -> OK
EGL + Zink : 4.6 (Compatibility Profile) Mesa 25.2.8 / zink Vulkan 1.4(llvmpipe) -> OK
```

Chart Jzy3D complet (`TestPanamaGLOffscreenCanvas` : surface + colorbar + texte, `debugGL` actif) :

```
-Dpanamagl.linux.context=egl  GALLIUM_DRIVER=zink  LIBGL_ALWAYS_SOFTWARE=1
-> test vert, libvulkan_lvp.so chargée (vérifié avec LD_DEBUG),
   image identique au pixel près à celle de GLX/llvmpipe (0 / 76 800 pixels différents)
```

Les autres constats :

* Zink via **GLX** sous Xvfb échoue (`DRI3 not available`) : Zink sous X exige DRI3/Kopper.
  Le chemin EGL surfaceless contourne le problème, et colle au modèle offscreen de PanamaGL.
* `LIBGL_ALWAYS_SOFTWARE=1` sert uniquement à autoriser Zink sur un device Vulkan CPU. Sur un
  vrai GPU, `GALLIUM_DRIVER=zink` suffit.
* Bonus : le contexte EGL permet de lancer la CI Linux **sans Xvfb**.

### Pour industrialiser (≈ 1 à 2 semaines)

1. Linux : générer les bindings EGL avec JExtract dans `panama-gl-bindings-linux`. Ajouter le
   choix du device (`EGL_EXT_device_enumeration`) et le fallback `EGL_DEFAULT_DISPLAY`. Exposer
   `GLProfile.getRenderer()` pour savoir si l'on tourne sur Zink.
2. Option de factory propre (`PanamaGLFactory.select(Backend.ZINK)`, ou propriété) plutôt qu'une
   simple variable d'environnement.
3. Windows : l'`opengl32.dll` de Mesa (mesa‑dist‑win) avec `GALLIUM_DRIVER=zink` fonctionne via
   WGL. Il faut un mécanisme de chargement d'un `opengl32.dll` alternatif (la même idée que
   `native.lib.path.windows` déjà présent en CI).
4. macOS : deux pistes à **spiker** avant tout engagement.
   * Zink + **KosmicKrisp** (Vulkan‑sur‑Metal de LunarG, upstream dans Mesa 26, conforme
     Vulkan 1.3) ou + MoltenVK. Mesa le documente comme expérimental, et le support du profil
     *compatibility* sur macOS n'est **pas confirmé**. Il faudrait construire Mesa pour macOS :
     aucun binaire officiel n'existe.
   * **ANGLE** (GLES 3 sur Metal) : pas de profil compatibility, donc il faut un painter GLES.
     Jzy3D a déjà `NativeEmbeddedPainter` + `GLES2CompatUtils` côté JOGL, et PanamaGL génère
     déjà les interfaces `GLES2_*`. Cette piste rejoint le niveau 2.
5. CI : un job Linux « Jzy3D sur Zink/lavapipe » qui fait tourner les tests PanamaGL
   existants. Il donne une couverture Vulkan pour presque rien.

**Limites** : il faut distribuer Mesa (Windows, macOS). Les performances dépendent de Zink
(généralement proches du natif). On reste borné par le modèle « un downcall par vertex » de
PanamaGLPainter.

## 4. Niveau 2 — Painter Vulkan (et Metal) natif

### Architecture proposée

```
jzy3d-core          IPainter
                        │
jzy3d-native-panama-ff  FixedFunctionPainter  (Java, indépendant du backend)
                        ├── MatrixStacks           (modelview / projection / texture, glGet*)
                        ├── ImmediateBatcher       (glBegin..glEnd → stream de sommets ;
                        │                           QUADS/POLYGON/LINE_LOOP triangulés/fermés)
                        ├── StateTracker           (depth, blend, cull, offset, polygon mode,
                        │                           stipple, point size, line width, stencil)
                        ├── UberShader             (éclairage 8 lumières, color material,
                        │                           flat/smooth, 6 clip planes, stipple)
                        ├── DisplayLists           (→ buffers GPU enregistrés)
                        ├── Text/DrawPixels        (AWT → texture → quad)
                        └── Picking/Feedback       (CPU : réutiliser la logique jGL,
                                                    ou picking par ID couleur)
                        │  RenderBackend (≈ 20 méthodes : buffers, pipeline(state), draw, readback)
        ┌───────────────┼──────────────────┬──────────────────┐
   GLCoreBackend   VulkanBackend      MetalBackend        (WebGPUBackend)
   (GL 3.3/4.1     (FFM sur vulkan.h,  (objc_msgSend via   (wgpu-native :
    core : macOS !) offscreen image +   FFM, MSL)           Vulkan/Metal/D3D12)
                    readback)
```

Côté PanamaGL, il faut **généraliser** `FBO`/`OffscreenRenderer`/`GLEventListener` en un
contrat neutre (`RenderTarget` + `FrameReader` + `RenderListener<C>`). Les canvas
AWT/Swing/JavaFX/SWT continuent d'afficher une image ; ils ne doivent plus dépendre de `GL`.

### Points délicats (et parades)

| Sujet | Problème | Parade |
|---|---|---|
| Lignes épaisses | `wideLines` absent sur Metal, MoltenVK, WebGPU | Expansion des lignes en quads (CPU ou vertex shader) |
| `glPolygonMode(LINE)` | `fillModeNonSolid` optionnel ; absent de WebGPU | Rendre les arêtes comme des lignes expansées |
| Points > 1 px, smooth | WebGPU : 1 px seulement | Quads + `discard` circulaire |
| Line stipple | n'existe plus | Distance cumulée en attribut + `discard` |
| Clip planes | `gl_ClipDistance` (Vulkan, Metal OK ; WebGPU par extension) | Fallback `discard` |
| Polygon offset | sémantique `depthBias` légèrement différente | Calibrer avec les tests d'images |
| Selection/feedback | n'existent pas | CPU : transformer et tester les primitives (jGL le fait déjà) ; ID‑color picking |
| Conventions | Vulkan : Y vers le bas, profondeur 0..1 | Corriger la projection ; flip au readback |
| Mode immédiat | coût par vertex | Batching par état ; `RecordingPainter` (niveau 3) |
| Depth peeling | FBO + shaders GL | Réimplémenter nativement (Vulkan : render passes, Metal : tile shaders) |
| Metal | pas d'API C | `objc_msgSend` par signature via FFM, ou passer par Vulkan‑sur‑Metal |

### Choix Vulkan / Metal / WebGPU

* **Vulkan** : API C, donc compatible JExtract. Bindings Java FFM existants (vulkan4j). Couvre
  Linux et Windows, et macOS via KosmicKrisp/MoltenVK.
* **Metal natif** : à n'envisager que si Vulkan‑sur‑Metal pose problème. Il faut un pont
  Objective‑C en FFM : faisable, puisque PanamaGL manipule déjà AppKit, mais coûteux à maintenir.
* **WebGPU (wgpu-native)** : un seul backend pour Vulkan, Metal et D3D12, avec plusieurs
  bindings Java FFM existants (webgpu-java, vulkan4j, wgpu4j). En contrepartie, l'API est la plus
  restrictive (points, lignes, polygon mode) et le header n'est pas encore stable. C'est une
  **alternative sérieuse à « Vulkan + Metal »** à trancher lors du spike.

## 5. Niveau 3 — Géométries capables d'utiliser OpenGL, Vulkan ou autre

Idée : les drawables décrivent **ce qu'ils sont** (maillage + matériau + états), pas
**comment le dessiner** appel par appel.

```java
interface RenderItem {               // produit par un Drawable, mis en cache
  Topology topology();               // TRIANGLES, LINES, POINTS (déjà triangulés)
  VertexData vertices();             // positions, normales, couleurs, uv (float[]/MemorySegment)
  IntBuffer indices();
  RenderState state();               // blend, depth, offset, width, stipple, lighting...
  long version();                    // incrémenté quand le drawable change
}
interface RenderBackend {            // GL (VBO), Vulkan, Metal, WebGPU, CPU (jGL)
  Handle upload(RenderItem item);
  void draw(Handle h, Matrices m, Lights l, ClipPlanes c);
  Image readback();
}
```

Migration progressive, sans casser l'existant :

1. **`RecordingPainter`** : un `IPainter` qui enregistre les appels immédiats d'un drawable en
   `RenderItem`. Il est invalidé quand le drawable change (`version`), et tous les drawables
   existants en profitent sans modification. Sur OpenGL, cela équivaut à un passage automatique
   aux VBO.
2. Réécrire nativement les drawables chauds en `RenderItem` : `Scatter`, `Shape`/surfaces,
   `LineStrip`, puis `DrawableVBO2` (déjà très proche).
3. Axes, texte, colorbars et overlays restent en mode immédiat via le `RecordingPainter`.

C'est la voie la plus **efficace** à terme : géométrie résidente GPU, et seules les matrices
changent quand la caméra tourne. Elle sert aussi le niveau 2, car un backend Vulkan sans mode
immédiat devient beaucoup plus simple.

## 6. Feuille de route proposée

| Phase | Contenu | Estimation* | Critère de sortie |
|---|---|---|---|
| 0 ✅ | POC EGL + Zink (ce document) | fait | chart Jzy3D identique au pixel près sur Vulkan |
| 1 🟡 | Industrialiser le niveau 1 Linux/Windows + job CI Zink ; spike macOS (Zink+KosmicKrisp vs ANGLE) | 1–2 sem. + 1 sem. spike | tests PanamaGL de Jzy3D verts sur Zink en CI. **Linux fait** : `EGLContext_linux`, `eglGetProcAddress`, GLUT à la demande, tests unitaires, démos, job CI Zink (voir [OpenGL-Ecosystem.md §5](OpenGL-Ecosystem.md#5-egl-en-détail-et-comment-il-se-greffe-à-gl-et-glext)). Restent : Windows (Zink), le spike macOS, et les tests Jzy3D en CI sur Zink. |
| 2 | `FixedFunctionPainter` + `RenderBackend` + `GLCoreBackend` | 4–6 sem. | `PainterGPUConformance` et tests d'images verts en GL core, y compris macOS 4.1 core |
| 3 | `VulkanBackend` (bindings JExtract `vulkan.h` dans panama-gl-bindings), cible offscreen + readback, généralisation des canvas PanamaGL | 4–6 sem. | mêmes tests verts sur lavapipe (CI) et un GPU réel ; macOS via KosmicKrisp |
| 4 | `RecordingPainter` + `RenderItem` pour Scatter/Surface | 3–4 sem. | gain FPS mesuré (benchmark grosse surface / 1M points) |
| 5 (option) | `MetalBackend` natif **ou** `WebGPUBackend` | 4–8 sem. | décidé selon le résultat de la phase 3 sur macOS |

\* Ordres de grandeur pour une personne, à recaler après la phase 1.

**Décision à prendre après la phase 1** : si Zink, ou Zink+KosmicKrisp, donne des résultats
satisfaisants partout, les phases 2‑3 deviennent optionnelles. Seule la phase 4 (performance)
garde un intérêt indépendant du backend.

## 7. Reproduire le POC

```bash
# Ubuntu 24.04 : Mesa (Zink + lavapipe) et un JDK >= 22
sudo apt-get install mesa-vulkan-drivers libegl1 openjdk-25-jdk-headless

# PanamaGL : test EGL, sur OpenGL natif puis sur Vulkan
mvn test -pl panama-gl-wrappers-linux -Dtest=TestEGLContext_linux
LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink \
  mvn test -pl panama-gl-wrappers-linux -Dtest=TestEGLContext_linux

# Jzy3D (après mvn install de panama-gl) : chart offscreen sur Vulkan, sans X
_JAVA_OPTIONS=-Dpanamagl.linux.context=egl LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink \
  mvn test -pl jzy3d-bindings/jzy3d-native-panama-gl-swing -Dtest=TestPanamaGLOffscreenCanvas
```

## 8. Zink ou couche de portage Java ?

### Retours d'expérience (hors Java ou proches)

| Source | Ce qu'on en retient |
|---|---|
| Fil Khronos *How to use OpenGL on Zink, Mesa, MoltenVK, and macOS* et mesa-dev *Enable OpenGL software rendering on macOS* (2022, Jzy3D) | Sur macOS, Mesa remplit ses pointeurs GL depuis `OpenGL.framework`. Le `libGL` de Mesa passe par GLX, donc X11/XQuartz. Charger un `libGL.dylib` osmesa via `DYLD_INSERT_LIBRARIES` + `LIBGL_ALWAYS_SOFTWARE` n'a pas abouti. À l'époque, les correctifs Zink+MoltenVK n'étaient pas publics. |
| Fil Khronos *Zink+MoltenVK+Gallium+mesa on macos compilation problems* (M2 Pro) | La compilation de Mesa sur macOS reste fragile (options meson, TLS dialect d'Apple clang). |
| Minecraft / Voxy sur macOS (fin 2025 – 2026) | Zink + **KosmicKrisp** + Metal fonctionne en GL 4.6 avec `MESA_LOADER_DRIVER_OVERRIDE=zink` et un **`libEGL.dylib` de Mesa chargé par LWJGL** : en Java, et via EGL. Il faut un Mesa compilé soi-même, voire un fork, macOS 26+, Apple Silicon et un GLFW patché. |
| Wine (MR brouillon, 2026) | Proposition d'utiliser Zink par défaut pour OpenGL-sur-Vulkan. |
| X-Plane, Kopper WGL | Zink sur Windows : GL 4.6 accéléré via `opengl32.dll` de Mesa (mesa-dist-win). |
| Benchmarks Phoronix / Igalia (2021-2022) | Performances de Zink entre ~80 % et ≥ 100 % du driver GL natif selon les jeux. Points lents : conversions de formats de sommets. |
| Profil compatibility | Limité à GL 3.0 en 2021 ; **GL 4.6 Compatibility** avec Mesa 25.2, d'après notre POC. |

Le cas Minecraft valide notre direction : en EGL, sans X11, on contourne exactement ce qui bloquait
en 2022 (GLX → XQuartz). Notre `EGLContext_linux` est transposable à macOS avec le `libEGL.dylib`
de Mesa.

### Ce que Zink apporte

* **Toute la sémantique GL, maintenue par d'autres** : pipeline fixe compilé en shaders, display
  lists, `GL_SELECT`/feedback, stipple, lignes épaisses, `glPolygonMode`, quads, clip planes.
  Le frontend GL de Mesa a des décennies de maturité, et Zink passe la CTS GL.
* **Il couvre aussi ce qui contourne `IPainter`** : code utilisateur qui fait `acquireGL()` et appelle
  `GL` directement, `GLSLProgram` et shaders GLSL fournis par l'utilisateur, `DrawableVBO2`, depth
  peeling, renderers texte et image de PanamaGL. Une couche Java ne couvre que ce qu'on réécrit.
* **Zéro ligne de rendu à écrire** : le POC montre une image identique au pixel près.
* **Un oracle de test** : Zink + lavapipe en CI fournit une référence Vulkan CPU gratuite.

### Ce que Zink coûte : les « galères de libs natives »

| OS | Situation |
|---|---|
| Linux | Mesa est presque toujours installé, donc **rien à distribuer**. Avec le pilote propriétaire NVIDIA, il faut sélectionner le vendeur Mesa (GLVND). |
| Windows | Il faut **distribuer** l'`opengl32.dll` de Mesa (plusieurs dizaines de Mo) et le charger à la place de celui de `system32`. Pièges connus : `opengl32.dll` vs `libEGL.dll` à ne pas mélanger, variables d'environnement mal réglées, ce qui donne « plus d'OpenGL du tout ». |
| macOS | **Aucun binaire officiel** : il faut compiler Mesa (meson, LLVM optionnel) pour x86_64 et arm64, livrer `libEGL`/`libGL` + KosmicKrisp ou MoltenVK + le loader Vulkan, puis **signer et notariser** les dylibs. Support qualifié d'« expérimental » par Mesa. |
| Tous | La configuration passe par des variables d'environnement globales au processus (`GALLIUM_DRIVER`…), fixées avant le lancement de la JVM. Le comportement dépend de la version de Mesa embarquée. Les crashs ont lieu en natif et sont opaques depuis Java. |

C'est précisément ce dont PanamaGL voulait se libérer (« only Java code, easy to rebuild »).

### Ce qu'apporte une couche Java

* **Dépendances natives = bibliothèques système uniquement** :
  * macOS : **Metal.framework + libobjc**, toujours présents. Un backend Metal en Java via
    `objc_msgSend` **n'a aucune lib native à livrer**, et les shaders MSL sont compilés par le système
    (`newLibraryWithSource`).
  * Linux/Windows : le loader Vulkan (`libvulkan.so.1` / `vulkan-1.dll`) est installé avec les pilotes
    GPU. Il peut manquer en VM, en RDP ou avec un « adaptateur d'affichage de base ».
  * Puisque le rendu est offscreen, on n'a **pas besoin du WSI** (surfaces et swapchains) : les
    bindings Vulkan sont **identiques sur tous les OS**, contrairement à GLX/WGL/CGL.
* **Shaders précompilés au build** : les uber-shaders GLSL sont compilés en SPIR-V par Maven
  (glslang) et embarqués comme ressources. On évite ainsi toute lib de compilation de shaders à
  l'exécution.
* Débogable en Java, comportement identique partout, et ouverture vers le modèle retenu (niveau 3)
  et l'enregistrement multi-thread des commandes.

**Limites** : effort important. On ne couvre que `IPainter`, pas le GL brut ni les shaders GLSL
utilisateur. Ceux-ci exigeraient un compilateur GLSL → SPIR-V natif (shaderc) ou de rester sur GL.

### Conclusion révisée

* Sur Linux et Windows, les pilotes OpenGL natifs fonctionnent. **Le vrai problème « hors OpenGL »,
  c'est macOS** (GL déprécié, plafonné à 4.1, et à 2.1 en compatibility). Il faut aussi surveiller
  Windows ARM, dont l'OpenGL passe déjà par une couche de traduction.
* **Zink** : chemin de compatibilité et **oracle de CI**. Il est quasi gratuit sur Linux (Mesa déjà
  présent), optionnel sur Windows, et seulement expérimental sur macOS, où il cumule les problèmes
  de libs natives.
* **Couche Java** : investissement stratégique, à **orienter d'abord vers Metal natif sur macOS**, car
  c'est le seul backend sans aucune lib native à livrer. Cela corrige la §2, qui proposait Metal via
  Vulkan-sur-Metal : sous l'angle des libs natives, KosmicKrisp ou MoltenVK réintroduisent une
  dylib à livrer et à signer. Vulkan passe en priorité secondaire, puisque GL natif reste disponible
  sur Linux et Windows.
* Le `FixedFunctionPainter` et son `GLCoreBackend` (§4) restent la première marche. Ils servent de
  banc d'essai, testé contre Zink et contre GL natif, avant d'écrire le backend Metal.
