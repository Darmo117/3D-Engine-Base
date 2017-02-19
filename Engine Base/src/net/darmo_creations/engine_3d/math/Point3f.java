package net.darmo_creations.engine_3d.math;

import java.util.Locale;

/**
 * Cette classe représente un point de l'espace.
 * 
 * @author Damien Vergnet
 */
public final class Point3f {
  private final float x, y, z;

  /**
   * Crée un point à l'origine (0, 0, 0).
   */
  public Point3f() {
    this(0, 0, 0);
  }

  /**
   * Crée un point en (x, y, z).
   * 
   * @param x l'abscisse
   * @param y l'ordonnée
   * @param z la profondeur
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

  public Point3f addX(float x) {
    return new Point3f(this.x + x, this.y, this.z);
  }

  public Point3f addY(float y) {
    return new Point3f(this.x, this.y + y, this.z);
  }

  public Point3f addZ(float z) {
    return new Point3f(this.x, this.y, this.z + z);
  }

  public Point3f add(Vector3f p) {
    return new Point3f(this.x + p.getX(), this.y + p.getY(), this.z + p.getZ());
  }

  @Override
  public String toString() {
    return String.format(Locale.ENGLISH, "%s[%f, %f, %f]", getClass().getSimpleName(), getX(), getY(), getZ());
  }
}
