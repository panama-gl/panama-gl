/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
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