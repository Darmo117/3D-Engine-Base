package net.darmo_creations.engine_3d.math;

import java.util.Locale;

public class Vector2f {
  private float x, y;

  public Vector2f() {
    this(0, 0);
  }

  public Vector2f(Vector2f v) {
    this(v.getX(), v.getY());
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

  public void addX(float v) {
    this.x += v;
  }

  public void addY(float v) {
    this.y += v;
  }

  public void mult(float v) {
    this.x *= v;
    this.y *= v;
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "%s[%f, %f]", getClass().getSimpleName(), getX(), getY());
  }
}
