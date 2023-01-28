package jextract.gl.generate.java.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class HelloDump implements Opcodes {
  public static void main(String[] args) {
    
     ClassWriter cw = new ClassWriter(0);
     FieldVisitor fv;
     MethodVisitor mv;
     AnnotationVisitor av0;

     cw.visit(49,
             ACC_PUBLIC + ACC_SUPER,
             "Hello",
             null,
             "java/lang/Object",
             null);

     cw.visitSource("Hello.java", null);

     {
         mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
         mv.visitVarInsn(ALOAD, 0);
         mv.visitMethodInsn(INVOKESPECIAL,
                 "java/lang/Object",
                 "<init>",
                 "()V");
         mv.visitInsn(RETURN);
         mv.visitMaxs(1, 1);
         mv.visitEnd();
     }
     {
         mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC,
                 "main",
                 "([Ljava/lang/String;)V",
                 null,
                 null);
         mv.visitFieldInsn(GETSTATIC,
                 "java/lang/System",
                 "out",
                 "Ljava/io/PrintStream;");
         mv.visitLdcInsn("hello");
         mv.visitMethodInsn(INVOKEVIRTUAL,
                 "java/io/PrintStream",
                 "println",
                 "(Ljava/lang/String;)V");
         mv.visitInsn(RETURN);
         mv.visitMaxs(2, 1);
         mv.visitEnd();
     }
     cw.visitEnd();

     //System.out.println(cw.to);
     //cw.toByteArray();
  }
}