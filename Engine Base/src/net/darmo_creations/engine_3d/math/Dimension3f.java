package net.darmo_creations.engine_3d.math;

/**
 * This class represents a dimension in a 3D space.
 * 
 * @author Damien Vergnet
 */
public final class Dimension3f {
  private final float width, height, length;
  private final Vector3f widthVector, heightVector, lengthVector;

  public Dimension3f(Dimension2f d, float length) {
    this(d.getWidth(), d.getHeight(), length);
  }

  public Dimension3f(float width, float height, float length) {
    this.width = width;
    this.height = height;
    this.length = length;
    this.lengthVector = new Vector3f(length, 0, 0);
    this.heightVector = new Vector3f(0, height, 0);
    this.widthVector = new Vector3f(0, 0, width);
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

  public Vector3f getWidthVector() {
    return this.widthVector.clone();
  }

  public Vector3f getHeightVector() {
    return this.heightVector.clone();
  }

  public Vector3f getLengthVector() {
    return this.lengthVector.clone();
  }
}
