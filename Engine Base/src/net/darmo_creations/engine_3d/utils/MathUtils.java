package net.darmo_creations.engine_3d.utils;

public class MathUtils {
  /**
   * @return the unsigned value of the argument byte
   */
  public static int getUnsignedByte(byte b) {
    return b & 0xff;
  }

  private MathUtils() {}
}
