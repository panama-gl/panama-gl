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
package panamagl.opengl;

import java.lang.foreign.Arena;
import panamagl.GLProfile;

public abstract class AGLContext implements GLContext {
  protected Arena arena;
  protected GLProfile profile;
  protected boolean initialized = false;

  protected void initArena() {
    arena = Arena.ofAuto();
  }

  @Override
  public GLProfile getProfile() {
    return profile;
  }

  @Override
  public void setProfile(GLProfile profile) {
    this.profile = profile;
  }

  @Override
  public boolean isInitialized() {
    return initialized;
  }
}
