package net.darmo_creations.engine_3d.utils;

import java.io.File;
import java.net.URISyntaxException;

public final class JarUtils {
  public static String getJarDir() {
    try {
      String path = JarUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();

      if (File.separatorChar == '\\') {
        path = path.replace('/', '\\');
        path = path.substring(1); // Removes the first /.
      }

      return path;
    }
    catch (URISyntaxException e) {
      return null;
    }
  }

  private JarUtils() {}
}
