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

  public void add(float tx, float ty, float tz) {
    this.x += tx;
    this.y += ty;
    this.z += tz;
  }

  public void add(Vector3f v) {
    add(v.getX(), v.getY(), v.getZ());
  }

  /**
   * Returns a copy of this point which is translated by the given vector as values.
   * 
   * @param tx vector x
   * @param ty vector y
   * @param tz vector z
   * @return the new point
   */
  public Point3f addNew(float tx, float ty, float tz) {
    return new Point3f(this.x + tx, this.y + ty, this.z + tz);
  }

  /**
   * Returns a copy of this point which is translated by the given vector.
   * 
   * @param v the vector
   * @return the new point
   */
  public Point3f addNew(Vector3f v) {
    return addNew(v.getX(), v.getY(), v.getZ());
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
