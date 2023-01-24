package panamagl.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import opengl.GL;
import opengl.GLContext;
import panamagl.OffscreenRenderer;
import panamagl.canvas.GLCanvasAWT;
import panamagl.canvas.GLCanvasSwing;
import panamagl.fbo.FBO;
import panamagl.os.OperatingSystem;
import panamagl.utils.ClassloaderUtils;

public interface PanamaGLFactory {

  GLCanvasAWT newCanvasAWT();
  GLCanvasSwing newCanvasSwing();

  GL newGL();
  GLContext newGLContext();

  FBO newFBO(int width, int height);
  OffscreenRenderer newOffscreenRenderer();

  void destroyContext();
  
  /** Indicates if this factory is compatible with the current {@link OperatingSystem}. */
  boolean matches(OperatingSystem os);
  
  /////////////////////////////////////////////////////
  //
  // Factory auto select
  //
  /////////////////////////////////////////////////////
  
  /** Returns the first factory that is is compatible with the current {@link OperatingSystem}.*/
  public static PanamaGLFactory select() {
    
    List<PanamaGLFactory> factories = findFactories();
    
    OperatingSystem os = new OperatingSystem();
    
    for(PanamaGLFactory factory : factories) {
      if(factory.matches(os)) {
        return factory;
      }
    }
    return null;
  }
  
  public static List<PanamaGLFactory> findFactories() {
    Class<?> exclude = APanamaGLFactory.class;
    Class<?> implem = PanamaGLFactory.class;
    String packge = "panamagl";

    return findFactories(exclude, implem, packge);
  }
  
  public static List<PanamaGLFactory> findFactories(Class<?> exclude, Class<?> implem, String packge) {
    List<PanamaGLFactory> factories = new ArrayList<>();

    try {
      
      for (Class<?> c : ClassloaderUtils.findFactoryClasses(packge, implem, exclude)) {
        try {
          PanamaGLFactory f = (PanamaGLFactory)c.getConstructors()[0].newInstance();
          factories.add(f);
        } catch (IllegalArgumentException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          e.printStackTrace();
        } catch (SecurityException e) {
          e.printStackTrace();
        } catch (InstantiationException e) {
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    return factories;
  }

}
