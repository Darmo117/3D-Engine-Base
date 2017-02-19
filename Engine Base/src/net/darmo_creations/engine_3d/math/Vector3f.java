package net.darmo_creations.engine_3d.math;

import java.util.Locale;

public class Vector3f implements Cloneable {
  public static Vector3f fromVector2f(Vector2f v) {
    return new Vector3f(v.getX(), v.getY(), 0);
  }

  private float x, y, z;

  public Vector3f() {
    this(0, 0, 0);
  }

  public Vector3f(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public float getX() {
    return this.x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return this.y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public float getZ() {
    return this.z;
  }

  public void setZ(float z) {
    this.z = z;
  }

  public void add(float tx, float ty, float tz) {
    this.x += tx;
    this.y += ty;
    this.z += tz;
  }

  public void add(Vector3f v) {
    add(v.getX(), v.getY(), v.getZ());
  }

  public void mult(float v) {
    this.x *= v;
    this.y *= v;
    this.z *= v;
  }

  @Override
  public Vector3f clone() {
    try {
      return (Vector3f) super.clone();
    }
    catch (CloneNotSupportedException e) {
      throw new Error(e);
    }
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "Vector3f[%f, %f, %f]", getX(), getY(), getZ());
  }
}
