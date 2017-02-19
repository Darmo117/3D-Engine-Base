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

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return this.y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public void add(float tx, float ty) {
    this.x += tx;
    this.y += ty;
  }

  public void add(Vector2f v) {
    add(v.getX(), v.getY());
  }

  public void mult(float v) {
    this.x *= v;
    this.y *= v;
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
