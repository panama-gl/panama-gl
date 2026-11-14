# Plan : painters PanamaGL Vulkan et Metal (OpenGL hors OpenGL)

Statut : **plan + POC du niveau 1**. Branche `claude/optimistic-cray-is2ldf`.

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
| 1 | Industrialiser le niveau 1 Linux/Windows + job CI Zink ; spike macOS (Zink+KosmicKrisp vs ANGLE) | 1–2 sem. + 1 sem. spike | tests PanamaGL de Jzy3D verts sur Zink en CI |
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
