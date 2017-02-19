package net.darmo_creations.engine_3d.math;

import java.util.Locale;

public class Vector3f {
  public static Vector3f fromVector2f(Vector2f v) {
    return new Vector3f(v.getX(), v.getY(), 0);
  }

  private float x, y, z;

  public Vector3f() {
    this(0, 0, 0);
  }

  public Vector3f(Vector3f v) {
    this(v.getX(), v.getY(), v.getZ());
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

  public void addX(float v) {
    this.x += v;
  }

  public void addY(float v) {
    this.y += v;
  }

  public void addZ(float v) {
    this.z += v;
  }

  public void mult(float v) {
    this.x *= v;
    this.y *= v;
    this.z *= v;
  }

  public void add(Vector3f v) {
    this.x += v.getX();
    this.y += v.getY();
    this.z += v.getZ();
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "%s[%f, %f, %f]", getClass().getSimpleName(), getX(), getY(), getZ());
  }
}
