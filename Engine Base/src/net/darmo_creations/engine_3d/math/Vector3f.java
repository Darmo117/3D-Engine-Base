package net.darmo_creations.engine_3d.math;

import java.util.Locale;

public class Vector3f implements Cloneable {
  public static Vector3f fromPoints(Point3f a, Point3f b) {
    return new Vector3f(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ());
  }

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

  public Vector3f setX(float x) {
    this.x = x;
    return this;
  }

  public float getY() {
    return this.y;
  }

  public Vector3f setY(float y) {
    this.y = y;
    return this;
  }

  public float getZ() {
    return this.z;
  }

  public Vector3f setZ(float z) {
    this.z = z;
    return this;
  }

  public float norm() {
    return MathUtils.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
  }

  public Vector3f add(float tx, float ty, float tz) {
    this.x += tx;
    this.y += ty;
    this.z += tz;

    return this;
  }

  public Vector3f add(Vector3f v) {
    return add(v.getX(), v.getY(), v.getZ());
  }

  public Vector3f mult(float v) {
    this.x *= v;
    this.y *= v;
    this.z *= v;

    return this;
  }

  public Vector3f rotate(float angle, Axis axis) {
    switch (axis) {
      case X: {
        float z = this.z;
        this.z = this.z * MathUtils.cos(angle) - this.y * MathUtils.sin(angle);
        this.y = z * MathUtils.sin(angle) + this.y * MathUtils.cos(angle);
        break;
      }
      case Y:
        float z = this.z;
        this.z = this.z * MathUtils.cos(angle) - this.x * MathUtils.sin(angle);
        this.x = z * MathUtils.sin(angle) + this.x * MathUtils.cos(angle);
        break;
      case Z:
        float x = this.x;
        this.x = this.x * MathUtils.cos(angle) - this.y * MathUtils.sin(angle);
        this.y = x * MathUtils.sin(angle) + this.y * MathUtils.cos(angle);
        break;
    }

    return this;
  }

  public Vector3f normalize() {
    float l = norm();

    if (l != 0) {
      this.x /= l;
      this.y /= l;
      this.z /= l;
    }

    return this;
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

  public static Vector3f crossProduct(Vector3f u, Vector3f v) {
    Vector3f w = new Vector3f();

    w.setX(u.getY() * v.getZ() - u.getZ() * v.getY());
    w.setY(u.getZ() * v.getX() - u.getX() * v.getZ());
    w.setZ(u.getX() * v.getY() - u.getY() * v.getX());

    return w;
  }
}
