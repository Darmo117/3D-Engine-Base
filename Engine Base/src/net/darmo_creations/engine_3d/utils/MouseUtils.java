package net.darmo_creations.engine_3d.utils;

import org.lwjgl.input.Mouse;

public class MouseUtils {
  public static final int LEFT_BUTTON = 0;
  public static final int RIGHT_BUTTON = 1;
  public static final int WHEEL = 2;

  public static boolean isLeftButtonDown() {
    return Mouse.isButtonDown(LEFT_BUTTON);
  }

  public static boolean isRightButtonDown() {
    return Mouse.isButtonDown(RIGHT_BUTTON);
  }

  public static boolean isWheelDown() {
    return Mouse.isButtonDown(WHEEL);
  }

  public static int getButtonDown() {
    for (int i = 0; i < 3; i++) {
      if (Mouse.isButtonDown(i))
        return i;
    }

    return -1;
  }

  private MouseUtils() {}
}
