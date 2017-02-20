package net.darmo_creations.engine_3d.math;

import java.util.Locale;

/**
 * This class represent a 3-dimensional point.
 * 
 * @author Damien Vergnet
 */
public class Point3f implements Cloneable {
  private float x, y, z;

  /**
   * Creates a point at (0, 0, 0).
   */
  public Point3f() {
    this(0, 0, 0);
  }

  /**
   * Creates a point at (x, y, z).
   */
  public Point3f(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public float getZ() {
    return this.z;
  }

  public Point3f add(float tx, float ty, float tz) {
    this.x += tx;
    this.y += ty;
    this.z += tz;

    return this;
  }

  public Point3f add(Vector3f v) {
    return add(v.getX(), v.getY(), v.getZ());
  }

  @Override
  public Point3f clone() {
    try {
      return (Point3f) super.clone();
    }
    catch (CloneNotSupportedException e) {
      throw new Error(e);
    }
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "%s[%f, %f, %f]", getClass().getSimpleName(), getX(), getY(), getZ());
  }
}
