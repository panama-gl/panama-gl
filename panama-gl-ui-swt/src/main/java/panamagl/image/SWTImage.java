/*******************************************************************************
 * Copyright (c) 2023 Martin Pernollet and others
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary Licenses when the
 * conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied:
 * GNU General Public License, version 2 with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package panamagl.image;

import java.io.FileOutputStream;
import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;

/**
 * Wraps an SWT {@link ImageData} to implement {@link panamagl.Image}.
 *
 * Uses {@link ImageData} rather than {@link Image} to avoid requiring a {@link Display} reference
 * for construction.
 */
public class SWTImage implements panamagl.Image<ImageData> {
  protected ImageData imageData;

  public SWTImage(ImageData imageData) {
    this.imageData = imageData;
  }

  @Override
  public ImageData getImage() {
    return imageData;
  }

  @Override
  public int getWidth() {
    return imageData.width;
  }

  @Override
  public int getHeight() {
    return imageData.height;
  }

  @Override
  public void save(String file) throws IOException {
    ImageLoader loader = new ImageLoader();
    loader.data = new ImageData[] {imageData};
    try (FileOutputStream out = new FileOutputStream(file)) {
      loader.save(out, SWT.IMAGE_PNG);
    }
  }

  public void setImageData(ImageData imageData) {
    this.imageData = imageData;
  }
}
