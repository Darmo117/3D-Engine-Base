package net.darmo_creations.engine_3d.utils;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.input.Keyboard;

public final class KeyboardUtils {
  private static final Map<String, Integer> KEYS = new HashMap<>();

  static {
    KEYS.put("forward", Keyboard.KEY_Z);
    KEYS.put("backward", Keyboard.KEY_S);
    KEYS.put("left", Keyboard.KEY_Q);
    KEYS.put("right", Keyboard.KEY_D);
    KEYS.put("up", Keyboard.KEY_SPACE);
    KEYS.put("down", Keyboard.KEY_LSHIFT);
  }

  public static boolean isForwardKeyPressed() {
    return isKeyTypePressed("forward");
  }

  public static boolean isBackwardKeyPressed() {
    return isKeyTypePressed("backward");
  }

  public static boolean isLeftKeyPressed() {
    return isKeyTypePressed("left");
  }

  public static boolean isRightKeyPressed() {
    return isKeyTypePressed("right");
  }

  public static boolean isUpKeyPressed() {
    return isKeyTypePressed("up");
  }

  public static boolean isDownKeyPressed() {
    return isKeyTypePressed("down");
  }

  public static boolean isKeyTypePressed(String id) {
    return Keyboard.isKeyDown(KEYS.get(id));
  }

  private KeyboardUtils() {}
}
