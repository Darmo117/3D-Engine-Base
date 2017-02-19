package net.darmo_creations.engine_3d.math;

public final class Dimension2f {
  private final float width, height;
  private final Vector2f widthVector, heightVector;

  public Dimension2f(float width, float height) {
    this.width = width;
    this.height = height;
    this.widthVector = new Vector2f(width, 0);
    this.heightVector = new Vector2f(0, height);
  }

  public float getWidth() {
    return this.width;
  }

  public float getHeight() {
    return this.height;
  }

  public Vector2f getWidthVector() {
    return this.widthVector;
  }

  public Vector2f getHeightVector() {
    return this.heightVector;
  }
}
