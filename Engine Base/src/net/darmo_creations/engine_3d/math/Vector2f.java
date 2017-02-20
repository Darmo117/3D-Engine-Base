package net.darmo_creations.engine_3d.math;

import java.util.Locale;

public class Vector2f implements Cloneable {
  private float x, y;

  public Vector2f() {
    this(0, 0);
  }

  public Vector2f(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float getX() {
    return this.x;
  }

  public Vector2f setX(float x) {
    this.x = x;
    return this;
  }

  public float getY() {
    return this.y;
  }

  public Vector2f setY(float y) {
    this.y = y;
    return this;
  }

  public Vector2f add(float tx, float ty) {
    this.x += tx;
    this.y += ty;

    return this;
  }

  public Vector2f add(Vector2f v) {
    return add(v.getX(), v.getY());
  }

  public Vector2f mult(float v) {
    this.x *= v;
    this.y *= v;

    return this;
  }

  @Override
  public Vector2f clone() {
    try {
      return (Vector2f) super.clone();
    }
    catch (CloneNotSupportedException e) {
      throw new Error(e);
    }
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "Vector2f[%f, %f]", getX(), getY());
  }
}
