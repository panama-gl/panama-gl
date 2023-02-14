package jextract.gl.xml;

import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import jextract.gl.generate.java.Arg;
import jextract.gl.xml.model.CommandWrap;
import junit.framework.Assert;

public class TestOpenGLRegistry {
  private static final String LONG = "long";
  private static final String FLOAT = "float";
  private static final String INT = "int";
  private static final String DOUBLE = "double";
  private static final String BYTE = "byte";
  private static final String STRING = "String";
  private static final String VOID = "void";
  private static final String ADDRESSABLE = "Addressable"; // java.lang.foreign.

  OpenGLRegistry registry;
  
  @Before
  public void before() throws Exception {
    registry = new OpenGLRegistry();
    
  }
  
  @Test
  public void all() throws Exception {
    List<CommandWrap> cw = registry.getCommands();
    Assert.assertEquals(3291, cw.size());
    
    
    Map<String,CommandWrap> commandIndex = registry.getCommandIndex();
    
    assert_glColor4f(commandIndex);
    assert_glGenLists(commandIndex);

    assert_glGetString(commandIndex);
    assert_glGetFloatv(commandIndex);
    assert_glGetDoublev(commandIndex);
    assert_glGetIntegerv(commandIndex);
    assert_glGetPointerv(commandIndex);
    
    assert_glMapBuffer(commandIndex);
    
    assert_glIndexPointer(commandIndex);
    assert_glMultiTexCoord2i(commandIndex);
    assert_glMultiTexCoord4i(commandIndex);
    assert_glGetProgramBinary(commandIndex);
    assert_glMultiDrawElements(commandIndex);
    assert_glBindBufferOffsetEXT(commandIndex);
    assert_glTransformFeedbackVaryingsEXT(commandIndex);
  }
  
  @Test
  public void single() throws Exception {
    Map<String,CommandWrap> commandIndex = registry.getCommandIndex();

    assert_glMultiTexCoord4i(commandIndex);


  }
  

  protected void assert_glColor4f(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glColor4f");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(4, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("red", a0.getName());
    Assert.assertEquals(FLOAT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("green", a1.getName());
    Assert.assertEquals(FLOAT, a1.getTypeName());

    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("blue", a2.getName());
    Assert.assertEquals(FLOAT, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("alpha", a3.getName());
    Assert.assertEquals(FLOAT, a3.getTypeName());
  }
  
  protected void assert_glGenLists(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGenLists");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(1, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("range", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    

    Assert.assertEquals(INT, command.getOutputType());
  }
  
  
  
  protected void assert_glMapBuffer(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glMapBuffer");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(2, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("target", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());

    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("access", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());

    Assert.assertEquals(VOID, command.getOutputType());

  }
  protected void assert_glGetString(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetString");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(1, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("name", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Assert.assertEquals(STRING, command.getOutputType());

  }

  
  protected void assert_glGetIntegerv(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetIntegerv");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(2, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("pname", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("data", a1.getName());
    Assert.assertEquals(ADDRESSABLE, a1.getTypeName());

  }

  protected void assert_glGetFloatv(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetFloatv");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(2, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("pname", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("data", a1.getName());
    Assert.assertEquals(ADDRESSABLE, a1.getTypeName());

  }

  protected void assert_glGetDoublev(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetDoublev");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(2, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("pname", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("data", a1.getName());
    Assert.assertEquals(ADDRESSABLE, a1.getTypeName());

  }
  
  
  protected void assert_glMultiTexCoord2i(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glMultiTexCoord2i");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(3, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("target", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("s", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());

    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("t", a2.getName());
    Assert.assertEquals(INT, a2.getTypeName());
  }

  protected void assert_glMultiTexCoord4i(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glMultiTexCoord4i");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(5, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("target", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("s", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());

    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("t", a2.getName());
    Assert.assertEquals(INT, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("r", a3.getName());
    Assert.assertEquals(INT, a3.getTypeName());

    Arg a4 = command.getArgs().get(4);
    Assert.assertEquals("q", a4.getName());
    Assert.assertEquals(INT, a4.getTypeName());

  }


  // glGetPointerv : void **
  protected void assert_glGetPointerv(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetPointerv");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(2, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("pname", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("params", a1.getName());
    Assert.assertEquals(ADDRESSABLE, a1.getTypeName());

  }
  
  // glIndexPointer : const void *

  protected void assert_glIndexPointer(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glIndexPointer");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(3, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("type", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("stride", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());
    
    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("pointer", a2.getName());
    Assert.assertEquals(ADDRESSABLE, a2.getTypeName());


  }
  
  // glGetProgramBinary : void *
  
  protected void assert_glGetProgramBinary(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glGetProgramBinary");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(5, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("program", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("bufSize", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());
    
    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("length", a2.getName());
    Assert.assertEquals(ADDRESSABLE, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("binaryFormat", a3.getName());
    Assert.assertEquals(ADDRESSABLE, a3.getTypeName());

    Arg a4 = command.getArgs().get(4);
    Assert.assertEquals("binary", a4.getName());
    Assert.assertEquals(ADDRESSABLE, a4.getTypeName());


  }

  protected void assert_glMultiDrawElements(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glMultiDrawElements");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(5, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("mode", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("count", a1.getName());
    Assert.assertEquals(ADDRESSABLE, a1.getTypeName());
    
    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("type", a2.getName());
    Assert.assertEquals(INT, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("indices", a3.getName());
    Assert.assertEquals(ADDRESSABLE, a3.getTypeName());

    Arg a4 = command.getArgs().get(4);
    Assert.assertEquals("drawcount", a4.getName());
    Assert.assertEquals(INT, a4.getTypeName());


  }
  
  
  
  protected void assert_glBindBufferOffsetEXT(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glBindBufferOffsetEXT");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(4, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("target", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("index", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());
    
    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("buffer", a2.getName());
    Assert.assertEquals(INT, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("offset", a3.getName());
    Assert.assertEquals(LONG, a3.getTypeName());

  }

  
  
  protected void assert_glTransformFeedbackVaryingsEXT(Map<String, CommandWrap> commandIndex) {
    CommandWrap command = commandIndex.get("glTransformFeedbackVaryingsEXT");
    
    Assert.assertNotNull(command);
    
    Assert.assertEquals(4, command.getArgs().size());
    
    
    Arg a0 = command.getArgs().get(0);
    Assert.assertEquals("program", a0.getName());
    Assert.assertEquals(INT, a0.getTypeName());
    
    Arg a1 = command.getArgs().get(1);
    Assert.assertEquals("count", a1.getName());
    Assert.assertEquals(INT, a1.getTypeName());
    
    Arg a2 = command.getArgs().get(2);
    Assert.assertEquals("varyings", a2.getName());
    Assert.assertEquals(ADDRESSABLE, a2.getTypeName());

    Arg a3 = command.getArgs().get(3);
    Assert.assertEquals("bufferMode", a3.getName());
    Assert.assertEquals(INT, a3.getTypeName());

  }
  

  
  
  // glGetProgramEnvParameterIivNV : <param len="4"><ptype>GLint</ptype> *<name>params</name></param>

}
