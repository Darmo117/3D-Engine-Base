package net.darmo_creations.engine_3d.utils;

public class MathUtils {
  public static final float PI = (float) Math.PI;
  public static final float TWO_PI = 2 * PI;
  public static final float PI_HALF = PI / 2;

  /**
   * @return the unsigned value of the argument byte
   */
  public static int getUnsignedByte(byte b) {
    return b & 0xff;
  }

  public static float cos(float x) {
    return (float) Math.cos(x);
  }

  public static float sin(float x) {
    return (float) Math.sin(x);
  }

  public static float tan(float x) {
    return (float) Math.tan(x);
  }

  private MathUtils() {}
}
