package net.darmo_creations.engine_3d.math;

/**
 * This class represents a dimension in a 3D space.
 * 
 * @author Damien Vergnet
 */
public final class Dimension3f {
  private final float width, height, length;

  public Dimension3f(Dimension2f d, float length) {
    this(d.getWidth(), d.getHeight(), length);
  }

  public Dimension3f(float width, float height, float length) {
    this.width = width;
    this.height = height;
    this.length = length;
  }

  public float getWidth() {
    return this.width;
  }

  public float getHeight() {
    return this.height;
  }

  public float getLength() {
    return this.length;
  }
}
