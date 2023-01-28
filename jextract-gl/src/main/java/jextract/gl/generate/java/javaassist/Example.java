package jextract.gl.generate.java.javaassist;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileWriter;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.ClassFile;

public class Example {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("A");
        
        // Création de la méthode m1
        CtMethod m1 = new CtMethod(CtClass.voidType, "m1", new CtClass[] {CtClass.intType}, cc);
        m1.setBody("{ System.out.println($1); }");
        cc.addMethod(m1);
        
        // Création de la méthode m2
        CtMethod m2 = new CtMethod(CtClass.voidType, "m2", new CtClass[] {pool.get("java.lang.String")}, cc);
        m2.setBody("{ System.out.println($1); }");
        cc.addMethod(m2);
        
        // Enregistrement de la classe (byte code only)
        //cc.writeFile();
        cc.writeFile("target/");
        //System.out.println(cc.toString());
        
        byte[] bytecode = cc.toBytecode();
        ClassFile classFile = new ClassFile(new DataInputStream(new ByteArrayInputStream(bytecode)));
        /*String javaSource = classFile.getJavaSource();
        FileWriter fw = new FileWriter("A.java");
        fw.write(javaSource);
        fw.flush();
        fw.close();*/
    }
}
