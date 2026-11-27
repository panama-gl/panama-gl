# L'écosystème OpenGL autour de PanamaGL : libs, couches, technos supportées

Ce document décrit les bibliothèques natives et les couches logicielles sur lesquelles PanamaGL
s'appuie, ou pourrait s'appuyer. Il sert de référence au plan
[Vulkan-Metal-Backends.md](Vulkan-Metal-Backends.md). Les faits marqués *(vérifié)* ont été
constatés sur le poste de test (Ubuntu 24.04, Mesa 25.2.8). Les autres viennent du code, de la CI ou
de la documentation des projets.

## Sommaire

1. [Vocabulaire](#1-vocabulaire)
2. [La pile en couches](#2-la-pile-en-couches)
3. [GL, `gl.h`, `glext.h` et le chargement des fonctions](#3-gl-glh-glexth-et-le-chargement-des-fonctions)
4. [Les API de liaison : GLX, WGL, CGL et EGL](#4-les-api-de-liaison--glx-wgl-cgl-et-egl)
5. [EGL en détail, et comment il se greffe à GL et GLEXT](#5-egl-en-détail-et-comment-il-se-greffe-à-gl-et-glext)
6. [Linux : GLVND, Mesa, DRI, X11, Xvfb, Wayland](#6-linux--glvnd-mesa-dri-x11-xvfb-wayland)
7. [Windows : opengl32.dll, ICD, WDDM et DDI](#7-windows--opengl32dll-icd-wddm-et-ddi)
8. [macOS : OpenGL.framework, CGL, Metal](#8-macos--openglframework-cgl-metal)
9. [Vulkan : loader, ICD, WSI](#9-vulkan--loader-icd-wsi)
10. [Couches de traduction et rendus logiciels](#10-couches-de-traduction-et-rendus-logiciels)
11. [Vue des technos supportées par PanamaGL](#11-vue-des-technos-supportées-par-panamagl)
12. [Glossaire](#12-glossaire)
13. [Historique (à venir)](#13-historique-à-venir)

---

## 1. Vocabulaire

| Terme | Sens ici |
|---|---|
| **API** | Une spécification : OpenGL, OpenGL ES, Vulkan, Metal, Direct3D, EGL… Elle ne contient aucun code. |
| **Header** | La déclaration C d'une API (`gl.h`, `glext.h`, `egl.h`, `vulkan.h`), source des **bindings** JExtract. |
| **Binding** | Le code Java généré par JExtract pour appeler une lib native (`panama-gl-bindings-*`). |
| **Wrapper** | Le code Java de PanamaGL qui adapte les bindings d'un OS à l'interface commune `GL` (`panama-gl-wrappers-*`). |
| **Loader / dispatcher** | La lib que l'application charge et qui aiguille vers l'implémentation réelle : `libGL.so` (GLVND), `opengl32.dll`, `libvulkan.so`. |
| **Implémentation / driver / ICD** | Le code qui exécute l'API : Mesa, le pilote NVIDIA ou AMD, le GL d'Apple. *ICD* = *Installable Client Driver*. |
| **API de liaison (WSI)** | La colle entre l'API graphique et le système : création de contexte, *make current*, surfaces, résolution des fonctions. GLX, WGL, CGL, EGL côté GL ; `VK_KHR_surface` côté Vulkan. |
| **Couche de traduction** | Une implémentation d'une API au-dessus d'une autre : Zink (GL→Vulkan), ANGLE (GLES→Metal/Vulkan/D3D), MoltenVK (Vulkan→Metal)… |

## 2. La pile en couches

```
 Application Java (Jzy3D, démos)
        │  IPainter / GLEventListener
 PanamaGL API ── interface GL (GL_1..GL_4, GLU, GLUT), GLContext, FBO, OffscreenRenderer
        │
 Wrappers ─────── GL_linux / GL_windows / GL_macOS, *Context_*, FBO_*, GLFunctionLoader_*
        │
 Bindings JExtract
   ├─ panama-gl-bindings-<os>   : fonctions exportées statiquement + GLU + GLUT + GLX/WGL/CGL
   └─ panama-gl-bindings-glext  : types PFNGL…PROC + constantes GL_* (commun à tous les OS)
        │  FFM (downcalls)
 ───────┼──────────────────────────────── frontière Java / natif ─────────────────────────────
        │
 Loader / dispatch    libGL.so.1 + libGLdispatch (GLVND) │ opengl32.dll │ OpenGL.framework
        │
 API de liaison       GLX │ EGL │ WGL │ CGL           (+ GLUT/freeglut, au-dessus de celles-ci)
        │
 Implémentation       Mesa (llvmpipe, radeonsi, iris, zink, d3d12…) │ NVIDIA │ AMD │ Intel │ Apple
        │                         │ zink                │ d3d12
        │                    Vulkan (loader + ICD)   Direct3D 12 (WARP ou GPU)
        │                         │ MoltenVK / KosmicKrisp (macOS)
        │                       Metal
 Noyau                DRM/KMS + DRI (Linux) │ WDDM (Windows) │ IOKit/IOGPU (macOS)
        │
 GPU (ou CPU pour llvmpipe, lavapipe, WARP)
```

PanamaGL rend **hors écran** (FBO puis `glReadPixels`) et affiche l'image avec le toolkit Java. Il
utilise donc l'API de liaison seulement pour **créer un contexte et le rendre courant**. Il
n'utilise ni surface fenêtre ni swap de buffers. C'est ce qui rend EGL *surfaceless* si naturel
(§5).

## 3. GL, `gl.h`, `glext.h` et le chargement des fonctions

### Pourquoi deux sortes d'appels

Une implémentation OpenGL expose ses fonctions de deux façons :

1. **Symboles exportés statiquement** par la lib du système, visibles par l'éditeur de liens. Leur
   liste est figée par l'ABI historique de chaque OS :
   * Windows : `opengl32.dll` n'exporte que **OpenGL 1.1** (1996), et cela n'a jamais changé ;
   * Linux : l'ABI Linux OpenGL de 2000 garantit **OpenGL 1.2** (+ `ARB_multitexture`). Les
     `gl.h` de Mesa en déclarent jusqu'à 1.3 ;
   * macOS : `OpenGL.framework` exporte **tout** ce qu'il implémente : 2.1 en legacy, 4.1 en core.
2. **Fonctions résolues à l'exécution** via un *GetProcAddress* de l'API de liaison :
   `wglGetProcAddress`, `glXGetProcAddress`, `eglGetProcAddress`. On obtient un pointeur qu'on appelle
   avec la bonne signature. C'est le mécanisme normal pour tout ce qui suit l'ABI de base : FBO, VBO,
   shaders, VAO…

### Les headers

| Header | Origine | Contenu |
|---|---|---|
| `GL/gl.h` | **l'OS** (Mesa, Windows SDK, macOS SDK) | Les fonctions exportées, plus des types et constantes. Contenu variable selon l'OS. |
| `GL/glext.h` | **Khronos** ([OpenGL-Registry](https://github.com/KhronosGroup/OpenGL-Registry)) | Toutes les fonctions après 1.1 et les extensions, sous forme de **prototypes**, de **types pointeurs `PFNGL…PROC`** et de **constantes**. |
| `GL/glcorearb.h` | Khronos | Variante « core profile uniquement » de `glext.h` (non utilisée ici). |
| `GL/glxext.h`, `GL/wglext.h`, `EGL/eglext.h` | Khronos | Extensions des API de liaison (ex. `glXCreateContextAttribsARB`, `EGL_KHR_no_config_context`). |
| `KHR/khrplatform.h` | Khronos | Types de base portables, partagés entre GL, GLES et EGL. |
| `GL/glu.h`, `GL/glut.h` | OS / freeglut | Bibliothèques utilitaires au-dessus de GL. |
| `OpenGL/OpenGL.h`, `OpenGL/gl.h`, `OpenGL/gl3.h` | Apple | CGL et GL legacy (2.1), GL core (4.1). |

### Comment PanamaGL les assemble

* **`panama-gl-bindings-<os>`** : JExtract sur le `gl.h` de l'OS + GLU + GLUT + l'API de liaison. Ces
  fonctions sont appelées **directement**.
  * Linux : `#include <GL/glut.h>` + `#include <GL/glx.h>`, ce qui tire `gl.h`, `glext.h`,
    `glxext.h` et `Xlib.h`. On obtient GL 1.0 à 1.3, GLU, GLUT, GLX et X11.
  * Windows : GL 1.1, GLU, freeglut, WGL et les déclarations Win32 utiles.
  * macOS : GL ≤ 2.1, GLUT et CGL.
* **`panama-gl-bindings-glext`** : JExtract sur le `glext.h` de Khronos, **sans** le `gl.h` de l'OS
  (`include_glext.h` déclare lui-même les types de base). On n'en garde que les types
  `PFNGL…PROC` et les constantes `GL_*`. Ces types ne décrivent que des **signatures**, donc ils
  sont identiques sur tous les OS et CPU. Exception : les 23 types utilisant `GLhandleARB`
  (`unsigned int`, mais `void*` sur macOS), laissés dans les bindings Linux et Windows.
* **`GLFunctionLoader_<os>`** résout une fonction à son premier appel, puis met le pointeur en cache.
  Le wrapper l'invoque ensuite via le type `PFNGL…PROC` de `glext` :
  * Linux : `glXGetProcAddress` (tout ce qui suit 1.3 : 2 508 fonctions de `GL_linux`) ;
  * Windows : `wglGetProcAddress`, puis les exports (tout ce qui suit 1.1 : 2 555 fonctions) ;
  * macOS : symboles du framework via `SymbolLookup.loaderLookup()` (les 141 fonctions 3.x absentes
    du `gl.h` legacy).

```
 gl.h de l'OS ──JExtract──► opengl.<os>.gl_h ──appel direct────────────────► lib GL système
 glext.h Khronos ─JExtract─► opengl.glext.PFNGLxxxPROC ─┐
                                                        ├─ invoke(ptr, args) ─► fonction du driver
 GLFunctionLoader_<os> ── *GetProcAddress("glXxx") ─────┘  (ptr mis en cache)
```

Contrainte qui en découle : sur Windows, un pointeur obtenu par `wglGetProcAddress` n'est valable
que pour le contexte et le pixel format courants. Un contexte doit donc être courant lors de la
première résolution, comme le dit déjà le README.

## 4. Les API de liaison : GLX, WGL, CGL et EGL

Elles ne dessinent rien. Elles **créent un contexte**, le **rendent courant** sur un thread, gèrent
des **surfaces** et **résolvent les fonctions**.

| | **GLX** | **WGL** | **CGL** | **EGL** |
|---|---|---|---|---|
| OS | Unix/X11 | Windows | macOS | Linux, Android, embarqué ; Windows et macOS via ANGLE ou Mesa |
| Normalisée par | SGI puis Khronos | Microsoft | Apple | **Khronos** |
| Lib | `libGLX.so` (via `libGL.so`) | `opengl32.dll` | `OpenGL.framework` | `libEGL.so.1` / `libEGL.dll` / `libEGL.dylib` |
| A besoin de | un **serveur X** (`DISPLAY`) | un `HDC`, donc une fenêtre (même cachée) | rien (contexte sans fenêtre) | **rien** en *surfaceless* ou *device* |
| Créer un contexte | `glXCreateContext(AttribsARB)` | `wglCreateContext(AttribsARB)` | `CGLCreateContext` | `eglCreateContext` |
| Rendre courant | `glXMakeCurrent` | `wglMakeCurrent` | `CGLSetCurrentContext` | `eglMakeCurrent` |
| Résoudre une fonction | `glXGetProcAddress` | `wglGetProcAddress` | symboles du framework | `eglGetProcAddress` |
| Profils / versions | `GLX_ARB_create_context(_profile)` | `WGL_ARB_create_context(_profile)` | legacy 2.1 / core 3.2→4.1 | attributs de `eglCreateContext` |
| API clientes | GL | GL | GL | **GL, GLES 1/2/3, OpenVG** |
| Dans PanamaGL | `GLXContext_linux` (défaut) | `WGLContext_windows` (défaut) | `CGLContext_macOS` (défaut) | `EGLContext_linux` (option, testé en CI) |

**GLUT/freeglut** n'est pas une API de liaison mais une boîte à outils au-dessus de celles-ci :
fenêtre, boucle d'événements, polices bitmap, teapot. PanamaGL l'utilise comme contexte alternatif
(`GLUTContext_*`) et pour les fonctions `glut*` de `GL`. Sur Linux, `glutInit` ouvre une connexion X :
GLUT rattache PanamaGL à X11 même quand le contexte vient d'EGL (à traiter, §5).

## 5. EGL en détail, et comment il se greffe à GL et GLEXT

### Ce qu'est EGL

EGL (*Embedded-System Graphics Library*) est l'API de liaison **normalisée par Khronos**. Elle est
née pour OpenGL ES et l'embarqué. Depuis EGL 1.4, `eglBindAPI(EGL_OPENGL_API)` donne aussi des
contextes **OpenGL desktop**. EGL 1.5 (2014) intègre les notions de *platform* et de contexte
versionné/profilé. C'est l'API de liaison de Wayland, d'Android, des GPU sans écran (serveurs, CI),
d'ANGLE, et désormais de Mesa sur toutes ses plateformes.

Les objets EGL :

| Objet | Rôle |
|---|---|
| `EGLDisplay` | Connexion à une **platform** : X11, Wayland, GBM (DRM), **surfaceless** (Mesa), **device** (un GPU donné, sans écran). Obtenu par `eglGetPlatformDisplay(EXT)`. |
| `EGLConfig` | Format de pixels d'une surface. Optionnel avec `EGL_KHR_no_config_context`. |
| `EGLSurface` | Fenêtre, pbuffer ou pixmap. Optionnelle avec `EGL_KHR_surfaceless_context`, car on rend dans un FBO. |
| `EGLContext` | Le contexte GL ou GLES, avec ses attributs (`EGL_CONTEXT_MAJOR_VERSION`, `EGL_CONTEXT_OPENGL_PROFILE_MASK` : core ou **compatibility**, debug…). |

Les extensions utiles à PanamaGL :

| Extension | Apport |
|---|---|
| `EGL_EXT_platform_base` / EGL 1.5 | Choisir explicitement la platform. |
| `EGL_MESA_platform_surfaceless` | Display **sans** X11, Wayland ni DRM-KMS : contexte purement hors écran *(vérifié)*. |
| `EGL_EXT_device_enumeration` + `EGL_EXT_platform_device` | Choisir un GPU précis sans écran. C'est la voie headless de NVIDIA. |
| `EGL_KHR_no_config_context` | Contexte sans `EGLConfig`. |
| `EGL_KHR_surfaceless_context` | `eglMakeCurrent` sans surface. |
| `EGL_KHR_create_context` | Version et profil du contexte, profil compatibility compris. |

Sur le poste de test, `eglinfo` montre que seule la platform *surfaceless* s'initialise (pas de GBM,
pas de Wayland, pas de X), et qu'elle offre GL 4.5 core, **4.5 compatibility** et GLES 3.2
*(vérifié)*.

### Où EGL se place par rapport à GL et GLEXT

EGL **remplace GLX, WGL ou CGL**, et **rien d'autre** :

```
                 avant (Linux)                          avec EGL
 contexte        glXCreateContext (libGLX)              eglCreateContext (libEGL)
 make current    glXMakeCurrent                         eglMakeCurrent
 résolution      glXGetProcAddress ──┐                  eglGetProcAddress ──┐
 GL 1.0-1.3      gl_h.glXxx (libGL) ─┤                  gl_h.glXxx ─────────┤  (libOpenGL)
 GL ≥ 1.4        PFNGL…PROC (glext) ◄┘                  PFNGL…PROC (glext) ◄┘  inchangé
```

* **`GL` et `glext` ne changent pas.** Les mêmes types `PFNGL…PROC` sont invoqués avec des
  pointeurs obtenus autrement. C'est pour cela que le POC n'a rien eu à modifier dans
  `GL_linux` ni dans `FBO_linux`.
* **Seule la colle change** : contexte (`EGLContext_linux`), et à terme résolution
  (`GLFunctionLoader_egl` avec `eglGetProcAddress`) et libs chargées.
* **GLES** : EGL est la seule voie normalisée pour obtenir un contexte GLES. PanamaGL génère déjà les
  interfaces `GLES1_1_0`, `GLES2_2_0`… Un wrapper GLES (ANGLE sur Metal, D3D ou Vulkan) passerait
  forcément par EGL.

### L'implémentation dans PanamaGL (Linux)

| Classe | Rôle |
|---|---|
| `EGL_linux` | Les 12 points d'entrée EGL utilisés, appelés par downcalls FFM écrits à la main. `libEGL.so.1` n'est ouvert qu'à la première utilisation : le chemin GLX ne le charge jamais. |
| `EGLContext_linux` | Contexte sans fenêtre : platform *surfaceless* (repli sur `EGL_DEFAULT_DISPLAY`), sans config ni surface, profil **compatibility** par défaut ou **core** via `setCoreProfile(major, minor)`. Expose la platform, la version, le vendeur et les API clientes EGL. |
| `GLFunctionLoader_linux` | Résout avec **`eglGetProcAddress`** dès qu'un contexte EGL a été créé dans le processus, avec `glXGetProcAddress` sinon. |
| `GLUT_linux` | Appelle `glutInit` au premier appel GLUT quand le contexte est EGL et qu'un `DISPLAY` existe. Sans display, lève une `UnsupportedOperationException` explicite au lieu de laisser freeglut terminer la JVM. Les 128 méthodes `glut*` de `GL_linux` l'appellent d'abord (générateur JExtractGL : `glutInitializer`). |
| `APanamaGLFactory_linux` | `setUseEGL(true)`, ou propriété `-Dpanamagl.linux.context=egl`, ou variable d'environnement `PANAMAGL_LINUX_CONTEXT=egl`. GLX reste le défaut. |

Constats faits en l'implémentant :

* **Un contexte *surfaceless* n'a pas de framebuffer par défaut** : dessiner hors d'un FBO lève
  `GL_INVALID_FRAMEBUFFER_OPERATION`. Ce n'est pas un problème, puisque PanamaGL dessine toujours
  dans un FBO, mais un test fixe ce comportement.
* **Le display EGL est partagé** par tous les contextes du processus : `destroy()` ne fait pas
  `eglTerminate`, qui invaliderait les contextes des autres canvas.
* **GLVND** : les stubs de `glXGetProcAddress` fonctionnent aussi avec un contexte EGL, parce que
  `libGLdispatch` suit le contexte courant quelle que soit l'API de liaison. Seul
  `eglGetProcAddress` garantit cependant les fonctions de l'implémentation choisie par EGL.
* **`GALLIUM_DRIVER` vaut pour tout le processus**, pas seulement pour PanamaGL. Sous Linux,
  JavaFX dessine lui-même avec OpenGL ES 2 sur GLX (pipeline Prism `es2`), tout comme le `GLCanvas`
  natif de SWT et freeglut. Sous Xvfb, sans DRI3, ces contextes GLX ne peuvent pas être créés sur
  Zink, et une scène JavaFX se bloque. Parade : `-Dprism.order=sw` (pipeline logiciel de JavaFX). Sur
  un bureau avec DRI3, GLX fonctionne aussi sur Zink.
* Avec `GALLIUM_DRIVER=zink`, freeglut affiche `glx: failed to create drisw screen` lors de
  `glutInit`. Il sonde GLX, ce qui échoue sous Xvfb, mais c'est sans conséquence : le dessin GLUT
  passe par le contexte EGL.

Tests (`panama-gl-wrappers-linux`) : `TestEGLContext_linux` (cycle de vie, sélection par la
factory, résolution par EGL, VBO, shaders, profils compatibility et core, plusieurs contextes,
absence de framebuffer par défaut, rendu en mode immédiat dans un FBO), `TestGLUT_linux` (sans et
avec display), `TestEGLContext_linux_Zink` (ignoré si `GALLIUM_DRIVER` ne vaut pas `zink` :
renderer Zink sur Vulkan, profil compatibility, rendu).

Démos : `panama-gl-samples` → `demos.panamagl.linux.DemoEGL_Offscreen` (headless, PNG + temps par
frame) et `DemoEGL_Onscreen_Swing` (fenêtre Swing) ; `jzy3d-tutorials-panama-gl-swing` →
`SurfaceDemo_PanamaGL_EGL` (fenêtre ou `--offscreen fichier.png`).

CI : le job **« Build & Test (OpenGL over Vulkan, Zink) »** installe lavapipe et lance toute la
suite avec `PANAMAGL_LINUX_CONTEXT=egl GALLIUM_DRIVER=zink`. Il exclut seulement les 5 classes qui
créent explicitement un contexte GLX ou GLUT, vérifie que le renderer est bien Zink, exécute la
démo headless et publie son image.

Reste à faire :

1. Générer les bindings EGL avec JExtract (`EGL/egl.h`, `EGL/eglext.h` du registre Khronos, non liés
   à l'OS : un module commun comme `glext`) à la place des downcalls écrits à la main.
2. Charger **`libOpenGL.so.0`** (GL seul) plutôt que `libGL.so.1` (= `libGLX` + `libOpenGL`), et ne
   charger `libGLX` et `libglut` qu'en mode GLX ou GLUT.
3. Choix du GPU par `EGL_EXT_device_enumeration` (voie headless NVIDIA), avant le repli
   *surfaceless* puis `EGL_DEFAULT_DISPLAY`.
4. Le wrapper généré de `glutInit` appelle l'initialiseur, puis `glutInit` une seconde fois, ce qui
   fait échouer freeglut. Personne ne l'appelle aujourd'hui, et c'est déjà le cas sous Windows, mais
   ce serait à corriger dans le générateur.

Sur **macOS** et **Windows**, la même architecture fonctionne si l'on fournit une lib EGL : celle de
Mesa (`libEGL.dylib` + Zink + KosmicKrisp, comme le font les joueurs de Minecraft sur Mac) ou celle
d'ANGLE (`libEGL.dylib`/`libEGL.dll`, GLES seulement). Dans les deux cas, il faut aussi charger le
`libGL`/`libGLESv2` **de la même distribution**, et pas `OpenGL.framework` ni `opengl32.dll`.
Mélanger les deux ne fonctionne pas : la doc de mmozeiko/build-mesa avertit qu'il ne faut pas lier
`opengl32.dll` quand on utilise `libEGL.dll`.

## 6. Linux : GLVND, Mesa, DRI, X11, Xvfb, Wayland

### GLVND, le dispatch d'OpenGL sous Linux

GLVND (*GL Vendor-Neutral Dispatch*, initié par NVIDIA, généralisé dans les distributions vers 2017) permet à plusieurs implémentations (Mesa, NVIDIA)
de coexister. Libs présentes sur le poste de test *(vérifié)* :

| Lib | Rôle |
|---|---|
| `libGL.so.1` | Compatibilité historique = `libGLX` + `libOpenGL`. **C'est celle que charge PanamaGL.** |
| `libOpenGL.so.0` | Les fonctions GL seules, sans API de liaison. |
| `libGLX.so.0` | Dispatch de GLX vers le vendeur de l'écran X (`libGLX_mesa.so.0`, `libGLX_nvidia.so.0`). |
| `libEGL.so.1` | Dispatch d'EGL vers les vendeurs listés dans `/usr/share/glvnd/egl_vendor.d/*.json` (ici `50_mesa.json` → `libEGL_mesa.so.0`). |
| `libGLESv2.so.2` | Les fonctions GLES. |
| `libGLdispatch.so.0` | La table de dispatch commune, qui suit le contexte courant du thread. |

Variables utiles : `__GLX_VENDOR_LIBRARY_NAME=mesa` force le vendeur GLX ;
`__EGL_VENDOR_LIBRARY_FILENAMES=…/50_mesa.json` force le vendeur EGL. C'est ce qui permet
d'utiliser Mesa/Zink sur une machine équipée du pilote NVIDIA propriétaire.

### Mesa

[Mesa](https://mesa3d.org) est l'implémentation libre d'OpenGL, GLES, Vulkan et OpenCL. Ce qui nous
concerne :

* les **frontends** : le *state tracker* GL (toute la sémantique GL, pipeline fixe compris, compilée
  en shaders NIR), GLX, EGL et WGL ;
* les **drivers Gallium** : `radeonsi` (AMD), `iris`/`crocus` (Intel), `nouveau`, `asahi` (Apple
  Silicon sous Linux), `llvmpipe`/`softpipe` (CPU), **`zink`** (GL→Vulkan), **`d3d12`** (GL→Direct3D
  12) ;
* les **drivers Vulkan** : `radv`, `anv`, `nvk`, **`lavapipe`** (CPU), **`kosmickrisp`**
  (Vulkan→Metal, Mesa 26) ;
* la sélection d'un driver : `GALLIUM_DRIVER=zink|llvmpipe|…`, `MESA_LOADER_DRIVER_OVERRIDE`,
  `LIBGL_ALWAYS_SOFTWARE=1` (logiciel ; avec Zink, cela autorise un device Vulkan CPU),
  `MESA_GL_VERSION_OVERRIDE`.

### DRI : Direct Rendering Infrastructure (le « DRI3 » cité plus haut)

Sous X11, le **DRI** permet à une application de dessiner **directement sur le GPU** sans faire
passer ses commandes par le serveur X, puis de partager le résultat avec lui.

| Version | Année | Principe |
|---|---|---|
| DRI1 | 1998 | Accès direct au GPU, verrou global, buffers gérés par le serveur. |
| DRI2 | 2008 | Buffers alloués par le serveur X, partagés par noms GEM. Encore utilisé par les serveurs X sans GPU. |
| **DRI3** (+ *Present*) | 2013 | Buffers alloués **par le client** (dma-buf), passés au serveur, qui les présente. C'est ce qu'utilisent les pilotes modernes. |
| **Kopper** | 2022 | Intégration fenêtre de **Zink** : il présente ses images à travers une swapchain Vulkan, et suppose DRI3 sous X11. |

Sous le kernel, DRI s'appuie sur **DRM/KMS** (*Direct Rendering Manager / Kernel Mode Setting*,
`/dev/dri/card*`, `/dev/dri/renderD*`). **GBM** (*Generic Buffer Management*) sert à allouer des
buffers GPU sans serveur d'affichage (platform EGL `gbm`).

C'est ce qui explique l'échec constaté : **Zink via GLX sous Xvfb → `DRI3 not available`** *(vérifié)*.
Xvfb n'implémente pas DRI3, et Kopper ne peut donc pas présenter d'images. EGL *surfaceless* n'a
besoin ni de X ni de DRI3, et c'est pour cela qu'il fonctionne.

### X11, Xvfb, Wayland

* **X11 / Xorg** : le protocole et le serveur d'affichage historiques d'Unix. GLX en dépend.
* **Xvfb** (*X Virtual FrameBuffer*) : un **serveur X sans écran ni GPU**, qui dessine dans un
  framebuffer en mémoire. Il sert à faire tourner des programmes graphiques sur des machines sans
  écran, comme les runners de CI. `xvfb-run` lance Xvfb, exporte `DISPLAY`, exécute la commande puis
  arrête le serveur. Sous Xvfb, le rendu GL est **forcément logiciel** : Mesa `llvmpipe` via GLX, sans
  DRI3. Sur le poste : `direct rendering: Yes`, renderer `llvmpipe`, GL 4.5 compatibility
  *(vérifié)*. La CI Linux de PanamaGL l'utilise
  (`xvfb-run --auto-servernum --server-args="-screen 0 1280x1024x24" mvn package`), parce que GLX et
  les composants AWT/Swing des tests ont besoin d'un `DISPLAY`.
* **Wayland** : le successeur de X11. Pas de GLX : **EGL est l'API de liaison** native. Sous Wayland,
  GLX ne marche que via **Xwayland**, un serveur X de compatibilité. EGL est donc aussi la voie
  d'avenir pour PanamaGL sous Linux, indépendamment de Vulkan.
* **XQuartz** : serveur X pour macOS. C'est lui qu'exigeait le `libGL` de Mesa sur Mac en 2022
  (GLX).

## 7. Windows : opengl32.dll, ICD, WDDM et DDI

* **`opengl32.dll`** (Microsoft) : loader **et** implémentation logicielle « GDI Generic » d'**OpenGL
  1.1**, qui n'a jamais évolué. Quand un pilote GPU est installé, `opengl32.dll` charge son **ICD**,
  déclaré dans le registre (`…\OpenGLDrivers`) : `nvoglv64.dll`, `atio6axx.dll`, `ig*icd64.dll`…
  Sans ICD (VM, runner CI, RDP, « adaptateur d'affichage de base »), on reste en GL 1.1 et
  `wglGetProcAddress` renvoie `NULL` pour tout le reste.
* **WGL** : l'API de liaison. Elle exige un `HDC`, donc une fenêtre éventuellement invisible.
  `WGL_ARB_create_context(_profile)` donne les contextes 3.x/4.x.
* **WDDM** (*Windows Display Driver Model*, depuis Vista) : le modèle de pilote. Un pilote se compose
  d'un **KMD** (*kernel-mode driver*) et d'un ou plusieurs **UMD** (*user-mode drivers*).
* **DDI** (*Device Driver Interface*) : dans la terminologie Microsoft, l'**interface que le runtime
  Direct3D appelle dans le pilote** (D3D11 DDI, D3D12 DDI), et celle que le noyau DirectX appelle
  dans le KMD. Un ICD OpenGL **ne passe pas** par le DDI Direct3D : il parle directement au noyau
  via les fonctions `D3DKMT*`. Remarque : dans les échanges précédents, j'ai parlé de **DRI3**
  (Linux, §6), pas de DDI. Les deux désignent une interface entre l'application, le système et le
  pilote, mais sur deux OS différents.
* **D3D12 et WARP** : WARP est le rasteriseur **logiciel** de Direct3D fourni par Windows, toujours
  disponible.
* **Mesa sur Windows** : un `opengl32.dll` de remplacement (mesa-dist-win, mmozeiko/build-mesa) qui
  embarque `llvmpipe`, `zink` ou `d3d12`. On le dépose à côté de l'application ou on le place en tête
  du chemin de recherche. Le driver **`d3d12`** (« GLOn12 ») traduit GL vers Direct3D 12. Microsoft le
  distribue sur Windows ARM dans l'« OpenCL and OpenGL Compatibility Pack ».
* **Ce que fait déjà la CI de PanamaGL** : sur `windows-latest` et `windows-11-arm`, elle télécharge
  le `opengl32.dll` **Mesa `d3d12`** de mmozeiko/build-mesa, le place dans `C:\mesa` et le met en
  tête de `java.library.path` (`-Dnative.lib.path.windows=C:\mesa;C:\Windows\system32`). **Les tests
  Windows de PanamaGL tournent donc déjà sur une couche de traduction GL → Direct3D 12 → WARP**, et
  pas sur un OpenGL natif. C'est un précédent direct pour Zink.
* **ANGLE** sur Windows : `libEGL.dll` + `libGLESv2.dll`, GLES sur Direct3D 11. C'est le moteur WebGL
  de Chrome, Edge et Firefox.

## 8. macOS : OpenGL.framework, CGL, Metal

* **`OpenGL.framework`** : l'implémentation d'Apple, **dépréciée depuis macOS 10.14 (2018)** et
  figée. Elle offre deux profils : **legacy 2.1** (pipeline fixe, c'est ce qu'utilise Jzy3D) et
  **core 3.2 → 4.1** (sans pipeline fixe). Pas de profil compatibility au-delà de 2.1. Sur Apple
  Silicon, Apple l'implémente au-dessus de Metal.
* **CGL** (*Core OpenGL*) : l'API de liaison C, sans fenêtre (contexte offscreen possible).
  **NSOpenGL** est la couche Cocoa au-dessus. **AGL** (Carbon) a disparu. **GLUT.framework** est
  déprécié lui aussi.
* **Metal** : l'API d'Apple depuis 2014. C'est une API **Objective-C/Swift, sans API C** :
  depuis Java, on passe par `objc_msgSend` du runtime `libobjc`. `Metal.framework` et `libobjc`
  sont **toujours présents**, il n'y a rien à livrer.
* **Vulkan sur Mac** : pas d'implémentation Apple. Il faut **MoltenVK** (Khronos, couche de
  portabilité, sous-ensemble de Vulkan) ou **KosmicKrisp** (LunarG/Mesa, Vulkan 1.3 conforme sur
  Apple Silicon, Mesa 26).
* **Mesa sur Mac** : historiquement `libGL` via GLX, donc XQuartz. Il se rabattait sur
  `OpenGL.framework` pour les pointeurs de fonctions (fils Khronos et mesa-dev de 2022). Aujourd'hui,
  `libEGL.dylib` + Zink + KosmicKrisp donnent GL 4.6, mais demandent une compilation maison et
  restent expérimentaux.
* **ANGLE** sur Mac : `libEGL.dylib` + `libGLESv2.dylib`, GLES 3 sur **Metal** (WebGL de Chrome et
  Safari).

## 9. Vulkan : loader, ICD, WSI

* **Loader** : `libvulkan.so.1`, `vulkan-1.dll` (installé avec les pilotes GPU) ou `libvulkan.dylib`
  (SDK). Il lit les manifestes ICD (`/usr/share/vulkan/icd.d/*.json`, par exemple `lvp_icd.json` →
  `libvulkan_lvp.so`) *(vérifié)*. On le surcharge avec `VK_DRIVER_FILES` / `VK_ICD_FILENAMES`.
* **ICD** : radv, anv, nvk, NVIDIA, AMD ; **lavapipe** (CPU) ; MoltenVK et KosmicKrisp (Mac).
* **WSI** (*Window System Integration*) : `VK_KHR_surface` + `VK_KHR_xlib_surface`,
  `VK_KHR_wayland_surface`, `VK_KHR_win32_surface`, `VK_EXT_metal_surface`, plus
  `VK_KHR_swapchain`. **C'est la seule partie de Vulkan qui dépend de l'OS.** Un rendu hors écran
  (image + copie vers un buffer) **n'en a pas besoin** : les bindings Vulkan d'un backend PanamaGL
  hors écran seraient identiques sur tous les OS.
* **Shaders** : Vulkan consomme du **SPIR-V**, compilé depuis GLSL par glslang ou shaderc. On peut le
  faire au build (Maven) pour n'avoir aucun compilateur natif à l'exécution.

## 10. Couches de traduction et rendus logiciels

| Couche | De → vers | OS | Distribution | Pertinence pour PanamaGL |
|---|---|---|---|---|
| **Zink** (Mesa) | GL 4.6 (core + compat) → Vulkan | Linux, Windows, macOS (exp.) | Mesa système (Linux) ; DLL à livrer (Windows) ; build maison (Mac) | **POC validé** sous Linux |
| **d3d12 / GLOn12** (Mesa) | GL 3.3+ → Direct3D 12 | Windows | `opengl32.dll` Mesa ; Compatibility Pack sur ARM | **déjà en CI Windows** |
| **ANGLE** (Google) | GLES 2/3 → Metal, Vulkan, D3D11, GL | tous | `libEGL` + `libGLESv2` à livrer | voie GLES (painter GLES nécessaire) |
| **MoltenVK** (Khronos) | Vulkan (sous-ensemble) → Metal | macOS, iOS | dylib à livrer (Apache 2) | Vulkan sur Mac |
| **KosmicKrisp** (LunarG/Mesa) | Vulkan 1.3 → Metal | macOS (Apple Silicon) | Mesa 26, build maison | Vulkan conforme sur Mac, support de Zink |
| **Dozen** (Mesa) | Vulkan → Direct3D 12 | Windows | Mesa | marginal |
| **gl4es** | GL 1.x/2.x → GLES 2 | Linux ARM, Android | lib à livrer | marginal |
| **llvmpipe** (Mesa) | GL → CPU (LLVM JIT) | tous | Mesa | CI Linux (Xvfb), tests sans GPU |
| **lavapipe** (Mesa) | Vulkan → CPU | Linux, Windows | Mesa | **CI Vulkan** (POC) |
| **WARP** (Microsoft) | Direct3D → CPU | Windows | système | CI Windows (sous d3d12) |
| **jGL / EmulGL** (Jzy3D) | GL 1.x → CPU **en Java** | tous (JVM) | aucune lib native | painter de secours de Jzy3D |

## 11. Vue des technos supportées par PanamaGL

Légende : ✅ supporté et testé en CI · 🧪 essai sur une branche · 🔭 envisagé dans le plan · ⚠️
possible mais non testé · ❌ non supporté.

### Plateformes, contextes et implémentations

| OS / CPU | API de liaison | Implémentation GL | Versions GL via `GL` | Statut |
|---|---|---|---|---|
| Linux x86_64, ARM64 | **GLX** (défaut) | pilote système ; en CI, Mesa llvmpipe sous **Xvfb** | 1.0 → 4.6 | ✅ |
| Linux | GLUT (`useGLUT`) | idem | idem | ✅ (option) |
| Linux | **EGL surfaceless** (`PANAMAGL_LINUX_CONTEXT=egl`, `-Dpanamagl.linux.context=egl` ou `setUseEGL(true)`) | Mesa llvmpipe | 4.5 compat | ✅ tests EGL dans le job Linux (sans X possible) |
| Linux | **EGL surfaceless + Zink** (`GALLIUM_DRIVER=zink`) | Mesa Zink → **Vulkan** (lavapipe) | 4.6 compat | ✅ job CI « OpenGL over Vulkan, Zink » (suite complète hors tests GLX/GLUT explicites) |
| Linux | EGL device (GPU NVIDIA headless) | pilote NVIDIA | — | ⚠️ |
| Linux / Wayland | EGL | pilote système | — | ⚠️ (Xwayland + GLX aujourd'hui) |
| Windows x86_64, ARM64 | **WGL** (défaut) | ICD du GPU ; en CI, **Mesa d3d12 → D3D12 → WARP** | 1.0 → 4.x | ✅ |
| Windows | GLUT (freeglut, optionnel) | idem | idem | ✅ (option) |
| Windows | WGL + Mesa Zink (`opengl32.dll` Mesa) | Zink → Vulkan | 4.6 | 🔭 |
| macOS ARM64, x86_64 | **CGL** (défaut) | `OpenGL.framework` (sur Metal en Apple Silicon) | 2.1 legacy ; 3.x en core | ✅ (x86_64 sur `main` uniquement) |
| macOS | GLUT.framework | idem | idem | ✅ (option) |
| macOS | EGL Mesa + Zink + KosmicKrisp/MoltenVK | Zink → Vulkan → Metal | 4.6 (non confirmé en compat) | 🔭 (expérimental) |
| macOS | EGL ANGLE | GLES 3 → Metal | GLES 3.0 | 🔭 (painter GLES requis) |

### Autres axes

| Axe | Supporté |
|---|---|
| JDK | 22+ (FFM) ; testé localement en 25 |
| Toolkits | AWT, Swing, JavaFX, SWT (✅) ; offscreen sans fenêtre (`PanamaGLOffscreenCanvas`, ✅) |
| API Java | `GL` = GL 1.0–3.3 + GLU + GLUT sur tous les OS ; 4.x sur Linux et Windows ; interfaces GLES générées mais sans wrapper (❌) |
| Painters Jzy3D | `PanamaGLPainter` (GL natif ✅) ; `FixedFunctionPainter` + backends GL core, Vulkan, Metal (🔭, voir le plan) |
| Backends non GL | Vulkan via FFM (🔭) ; Metal via `objc_msgSend` (🔭) ; WebGPU via wgpu-native (🔭, à départager) |

### Libs natives requises, par configuration

| Configuration | Libs chargées | À livrer avec l'application ? |
|---|---|---|
| Linux GLX | `libGL.so.1`, `libGLX`, `libGLU`, `libglut` | non (paquets système ; `freeglut3` peut manquer) |
| Linux EGL (POC) | `libEGL.so.1`, `libGL.so.1` (→ `libOpenGL.so.0` à terme) | non |
| Linux EGL + Zink | idem + `libvulkan.so.1` + ICD Vulkan | non (Mesa système) |
| Windows WGL | `opengl32.dll`, `glu32.dll` (+ `freeglut.dll` optionnel, embarqué dans un jar) | non, hors freeglut |
| Windows Mesa (CI) | `opengl32.dll` Mesa + ses DLL | **oui** (aujourd'hui en CI uniquement) |
| macOS CGL | `OpenGL.framework`, `GLUT.framework` | non |
| macOS Zink | `libEGL.dylib` + `libGL` Mesa + KosmicKrisp ou MoltenVK + loader Vulkan | **oui**, à compiler, signer et notariser |
| macOS Metal natif (🔭) | `Metal.framework`, `libobjc` | **non** |

## 12. Glossaire

| Terme | Définition |
|---|---|
| **ANGLE** | *Almost Native Graphics Layer Engine* : GLES au-dessus de D3D11, Vulkan, Metal ou GL (Google). |
| **CGL** | *Core OpenGL* : API de liaison C de macOS. |
| **DDI** | *Device Driver Interface* (Windows) : interface entre le runtime Direct3D (ou le noyau DirectX) et le pilote. |
| **DRI / DRI2 / DRI3** | *Direct Rendering Infrastructure* (Linux/X11) : rendu GPU direct par le client et partage des buffers avec le serveur X. Zink sous X11 exige DRI3. |
| **DRM / KMS** | *Direct Rendering Manager / Kernel Mode Setting* : sous-système GPU du noyau Linux. |
| **EGL** | API de liaison Khronos, multi-plateforme, pour GL et GLES. Permet les contextes sans fenêtre. |
| **FBO** | *Framebuffer Object* : cible de rendu hors écran en GL (ce que fait PanamaGL). |
| **GBM** | *Generic Buffer Management* : allocation de buffers GPU sans serveur d'affichage (Linux). |
| **GLEXT** | `glext.h` (Khronos) : prototypes, types pointeurs et constantes de tout GL après 1.1. Module `panama-gl-bindings-glext`. |
| **GLVND** | *GL Vendor-Neutral Dispatch* : dispatch Linux permettant à plusieurs implémentations GL de coexister. |
| **GLX / WGL** | API de liaison de X11 et de Windows. |
| **ICD** | *Installable Client Driver* : l'implémentation fournie par le vendeur et chargée par le loader (GL sous Windows, Vulkan partout). |
| **Kopper** | Intégration fenêtre de Zink par swapchain Vulkan (Mesa 22+). |
| **lavapipe / llvmpipe** | Vulkan et GL logiciels de Mesa (CPU, LLVM). |
| **MoltenVK / KosmicKrisp** | Vulkan sur Metal (Khronos / LunarG-Mesa). |
| **SPIR-V** | Format binaire des shaders Vulkan (et OpenCL, et GL 4.6). |
| **Surfaceless** | Contexte rendu courant sans surface : on dessine dans un FBO. |
| **UMD / KMD** | *User/Kernel-Mode Driver* : les deux moitiés d'un pilote WDDM. |
| **WARP** | *Windows Advanced Rasterization Platform* : Direct3D logiciel de Windows. |
| **WDDM** | *Windows Display Driver Model* : modèle de pilotes graphiques depuis Vista. |
| **WSI** | *Window System Integration* : partie dépendante de l'OS d'une API graphique (surfaces, présentation). |
| **Xvfb** | *X Virtual FrameBuffer* : serveur X sans écran ni GPU, rendu en mémoire ; utilisé en CI. |
| **XQuartz / Xwayland** | Serveurs X de compatibilité sur macOS et sous Wayland. |
| **Zink** | Driver Gallium de Mesa implémentant OpenGL au-dessus de Vulkan. |

## 13. Historique (à venir)

Trame prévue, à documenter dans un second temps :

* **1992–2000** : IrisGL → OpenGL 1.0 (SGI) ; GLX ; WGL et `opengl32.dll` figé en 1.1 (1996) ; ABI
  Linux OpenGL (2000) ; Mesa (1993) ; GLUT.
* **2000–2008** : ARB, extensions et `glext.h` ; OpenGL 2.0 et GLSL (2004) ; OpenGL ES et EGL
  (Khronos, 2003) ; DRI1 → DRI2 ; Gallium3D (2008).
* **2008–2014** : OpenGL 3.0, dépréciation du pipeline fixe, profils core et compatibility (3.2,
  2009) ; ANGLE (2010) ; Wayland et EGL ; DRI3 (2013) ; Metal (2014).
* **2015–2020** : Vulkan 1.0 (2016) ; MoltenVK ouvert (2018) ; dépréciation d'OpenGL par Apple
  (2018) ; GLVND ; Zink (2018) ; d3d12/GLOn12 (2020) ; Panama/FFM en incubation.
* **2021–2026** : Zink GL 4.6 et Kopper ; FFM finalisé (JDK 22, 2024) ; PanamaGL ; KosmicKrisp
  (Mesa 26) ; Wine et Zink par défaut (proposition) ; POC PanamaGL EGL + Zink.

## Sources

* Khronos : [OpenGL-Registry](https://github.com/KhronosGroup/OpenGL-Registry), [EGL-Registry](https://github.com/KhronosGroup/EGL-Registry), [Load OpenGL Functions](https://www.khronos.org/opengl/wiki/Load_OpenGL_Functions)
* Mesa : [Zink](https://docs.mesa3d.org/drivers/zink.html), [variables d'environnement](https://docs.mesa3d.org/envvars.html)
* [mesa-dist-win](https://github.com/pal1000/mesa-dist-win), [mmozeiko/build-mesa](https://github.com/mmozeiko/build-mesa)
* [LunarG – KosmicKrisp](https://www.lunarg.com/lunarg-achieves-vulkan-1-3-conformance-with-kosmickrisp-on-apple-silicon/)
* Code PanamaGL : `README.md` (*GL API and implementations*), `.github/workflows/ci.yml`,
  `panama-gl-bindings/scripts/*`, `GLFunctionLoader_*`, `EGLContext_linux`.
