package net.darmo_creations.engine_3d.scene;

import org.lwjgl.opengl.GL11;

public enum LightId {
  LIGHT_0,
  LIGHT_1,
  LIGHT_2,
  LIGHT_3,
  LIGHT_4,
  LIGHT_5,
  LIGHT_6,
  LIGHT_7;

  public int getValue() {
    return GL11.GL_LIGHT0 + ordinal();
  }

  public static LightId fromIndex(int index) {
    return values()[index];
  }

  public static int availableLightsNb() {
    return values().length;
  }
}
