package net.darmo_creations.engine_3d.math;

public class MathUtils {
  public static final float PI = (float) Math.PI;
  public static final float TWO_PI = 2 * PI;
  public static final float HALF_PI = PI / 2;

  /**
   * @return the unsigned value of the argument byte
   */
  public static int getUnsignedByte(byte b) {
    return b & 0xff;
  }

  public static float map(float v, float min, float max, float newMin, float newMax) {
    return newMin + (newMax - newMin) * ((v - min) / (max - min));
  }

  public static float sqrt(float x) {
    return (float) Math.sqrt(x);
  }

  public static float pow(float a, float b) {
    return (float) Math.pow(a, b);
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

  /**
   * Returns the normal vector to the given plane.
   * 
   * @return the normal to the plane
   */
  public static Vector3f normal(Point3f p1, Point3f p2, Point3f p3) {
    Vector3f u = Vector3f.fromPoints(p1, p2);
    Vector3f v = Vector3f.fromPoints(p1, p3);

    return Vector3f.crossProduct(u, v).normalize();
  }

  private MathUtils() {}
}
