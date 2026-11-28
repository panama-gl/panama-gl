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
package panamagl.platform.natives;

/** A {@link NativeBundle} that could not be found, verified, extracted or loaded. */
public class NativeBundleException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /** What went wrong. */
  public enum Reason {
    /** The bundle is not in the classpath for this platform. */
    NOT_FOUND,
    /** The manifest is malformed or refers to unsafe file names. */
    INVALID_MANIFEST,
    /** A file of the classpath differs from the manifest : truncated or modified jar. */
    CORRUPTED,
    /** No directory could hold the extracted files. */
    NOT_EXTRACTED,
    /** A library could not be loaded. */
    NOT_LOADED
  }

  protected final Reason reason;

  public NativeBundleException(Reason reason, String message) {
    super(message);
    this.reason = reason;
  }

  public NativeBundleException(Reason reason, String message, Throwable cause) {
    super(message, cause);
    this.reason = reason;
  }

  public Reason getReason() {
    return reason;
  }
}
