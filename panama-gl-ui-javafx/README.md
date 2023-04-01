
https://stackoverflow.com/questions/16946030/how-to-use-opengl-in-javafx

TODO
- All FBO must keep spare readPixel buffer usage like on windows
- Provide a CanvasFactory or ToolkitFactory to init ThreadRedirect, Canvas and Image. Rename
PanamaGLFactory to OpenGLFactory, then provide ToolkitFactory to OpenGLFactory.
- animator sleepTime is not considered!!
- Verifier que le resize marche encore sur Swing et macOS/linux. AOffscreenRenderer doit soit ne pas utiliser la taille du drawable, soit dégager les arguments
- Trouver une bonne manière de connaître la taille du canvas sans faire appel à la scene!! ET
CORRIGER
- Trouver la propriété pour permettre au canvas de grandir dans la scene
- Pourquoi ça saute quand on resize? Conflit de rendu car le flag isRendering n'est en réalité
pas effectif?

TESTS
- JavaFX isRendering is not properly working