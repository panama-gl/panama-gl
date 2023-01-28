package jextract.gl.generate.java;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class ClassCompiler {
  protected List<String> options = Arrays.asList("--enable-preview", "--release", "19");

  public List<String> getOptions() {
    return options;
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }

  public boolean compile(List<String> names) throws IOException {
    // Récupérer l'instance de l'outil de compilation
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    // Obtenir un gestionnaire de fichiers pour les fichiers Java
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

    // Obtenir les fichiers Java à partir du nom de fichier fourni en entrée
    Iterable<? extends JavaFileObject> javaFiles = fileManager.getJavaFileObjectsFromStrings(names);

    // Lancer la compilation
    boolean success = compiler.getTask(null, fileManager, null, options, null, javaFiles).call();

    // Fermer le gestionnaire de fichiers
    fileManager.close();

    // Afficher un message de réussite ou d'échec
    if (success) {
      System.out.println("Compilation réussie");
    } else {
      System.out.println("Echec de la compilation");
    }

    return success;
  }
}
