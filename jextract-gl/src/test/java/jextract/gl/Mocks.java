package jextract.gl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Mocks {
  public static Method method(String name, Parameter[] input, Class<?> outputType) {
    Method m = mock(Method.class);

    when(m.getName()).thenReturn(name);
    when(m.getParameters()).thenReturn(input);
    // when(m.getReturnType()).thenReturn(outputType);

    when(m.getReturnType()).thenAnswer(new Answer<Object>() {
      @Override
      public Object answer(InvocationOnMock i) throws Throwable {
        return outputType;
      }
    });

    return m;
  }

  public static Parameter param(String name, Class<?> type) {
    Parameter p1 = mock(Parameter.class);
    when(p1.getName()).thenReturn(name);
    when(p1.getType()).thenAnswer(new Answer<Object>() {
      @Override
      public Object answer(InvocationOnMock i) throws Throwable {
        return type;
      }
    });
    return p1;
  }
}
