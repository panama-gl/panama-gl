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
package demos.panamagl.rendering;

import java.util.List;
import java.util.function.Supplier;

/** The scenes used to compare the rendering backends. */
public class Scenes {
  public static List<Supplier<Scene>> all() {
    return List.of(BasicScene::new, FractalScene::new, PlanetScene::new, LandscapeScene::new,
        StillLifeScene::new);
  }

  /** @return the scene of the given name, or null. */
  public static Scene byName(String name) {
    for (Supplier<Scene> s : all()) {
      Scene scene = s.get();
      if (scene.getName().equalsIgnoreCase(name))
        return scene;
    }
    return null;
  }
}
