/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.platform.windows;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * The few functions of kernel32 and of the C runtime used to load Mesa : finding a loaded DLL, and
 * setting environment variables read by native code (Mesa, the Vulkan loader), which
 * {@link System#getenv()} cannot do.
 */
final class Kernel32_windows {
  private static final Linker LINKER = Linker.nativeLinker();
  private static final SymbolLookup KERNEL32 = SymbolLookup.libraryLookup("kernel32", Arena.global());

  private static final MethodHandle GetModuleHandleW = LINKER.downcallHandle(
      KERNEL32.find("GetModuleHandleW").orElseThrow(), FunctionDescriptor.of(ADDRESS, ADDRESS));
  private static final MethodHandle GetModuleFileNameW = LINKER.downcallHandle(
      KERNEL32.find("GetModuleFileNameW").orElseThrow(),
      FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, JAVA_INT));
  private static final MethodHandle GetEnvironmentVariableW = LINKER.downcallHandle(
      KERNEL32.find("GetEnvironmentVariableW").orElseThrow(),
      FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, JAVA_INT));
  private static final MethodHandle SetEnvironmentVariableW = LINKER.downcallHandle(
      KERNEL32.find("SetEnvironmentVariableW").orElseThrow(),
      FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS));

  private Kernel32_windows() {}

  /** @return the path of the loaded DLL of the given name, e.g. "opengl32.dll", if loaded. */
  static Optional<String> loadedModule(String name) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment module = (MemorySegment) GetModuleHandleW.invokeExact(wide(arena, name));
      if (module.address() == 0)
        return Optional.empty();
      int capacity = 32768;
      MemorySegment buffer = arena.allocate(capacity * 2L);
      int length = (int) GetModuleFileNameW.invokeExact(module, buffer, capacity);
      if (length <= 0)
        return Optional.of(name);
      return Optional.of(new String(buffer.asSlice(0, length * 2L).toArray(java.lang.foreign.ValueLayout.JAVA_BYTE),
          StandardCharsets.UTF_16LE));
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  /**
   * Set an environment variable of the process, for the native code that reads it : in the
   * environment block of Windows (GetEnvironmentVariable, read by the Vulkan loader), and in the
   * tables of the Universal C Runtime (getenv, read by Mesa when it shares the CRT of the JVM). A
   * DLL with its own C runtime copies the environment block when loaded : set variables first.
   */
  static void setenv(String name, String value) {
    try (Arena arena = Arena.ofConfined()) {
      int ok = (int) SetEnvironmentVariableW.invokeExact(wide(arena, name), wide(arena, value));
      if (ok == 0)
        throw new IllegalStateException("SetEnvironmentVariableW failed for " + name);
      ucrtPutenv(arena, name, value);
    } catch (RuntimeException e) {
      throw e;
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  /** @return the variable in the environment block of Windows, as read by the Vulkan loader. */
  static Optional<String> getenv(String name) {
    try (Arena arena = Arena.ofConfined()) {
      int capacity = 32767;
      MemorySegment buffer = arena.allocate(capacity * 2L);
      int length = (int) GetEnvironmentVariableW.invokeExact(wide(arena, name), buffer, capacity);
      if (length <= 0)
        return Optional.empty();
      return Optional.of(new String(buffer.asSlice(0, length * 2L).toArray(java.lang.foreign.ValueLayout.JAVA_BYTE),
          StandardCharsets.UTF_16LE));
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  /** @return the variable as read by getenv of the Universal C Runtime, e.g. by Mesa. */
  static Optional<String> crtGetenv(String name) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment getenv = SymbolLookup.libraryLookup("ucrtbase", Arena.global()).find("getenv").orElseThrow();
      MethodHandle h = LINKER.downcallHandle(getenv, FunctionDescriptor.of(ADDRESS, ADDRESS));
      MemorySegment value = (MemorySegment) h.invokeExact(arena.allocateFrom(name));
      return value.address() == 0 ? Optional.empty()
          : Optional.of(value.reinterpret(32767).getString(0));
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  private static void ucrtPutenv(Arena arena, String name, String value) throws Throwable {
    Optional<MemorySegment> putenv;
    try {
      putenv = SymbolLookup.libraryLookup("ucrtbase", Arena.global()).find("_wputenv_s");
    } catch (IllegalArgumentException noUcrt) {
      return;
    }
    if (putenv.isPresent()) {
      MethodHandle h = LINKER.downcallHandle(putenv.get(), FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS));
      int ignored = (int) h.invokeExact(wide(arena, name), wide(arena, value));
    }
  }

  private static MemorySegment wide(Arena arena, String s) {
    return arena.allocateFrom(s, StandardCharsets.UTF_16LE);
  }
}
