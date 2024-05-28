package demos.opengl;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

// https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/lang/foreign/Arena.html
public class FFM_Arena_Shared {

  public static void main(String[] args) {

    int max = 1_000_000;
    int siz = 1_000_000;


    for (int i = 0; i < max; i++) {
      Arena arena = Arena.ofConfined();
      MemorySegment s = arena.allocate(siz);
      s.get(ValueLayout.JAVA_BYTE, 0);

      arena.close();

      System.out.println("Progress : " + (100f * i / max) + "%");
    }

    System.out.println("Done testing");
  }

}
