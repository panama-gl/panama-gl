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
