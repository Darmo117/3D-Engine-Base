package net.darmo_creations.engine_3d.math;

import java.util.Locale;

import net.darmo_creations.engine_3d.utils.MathUtils;

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
