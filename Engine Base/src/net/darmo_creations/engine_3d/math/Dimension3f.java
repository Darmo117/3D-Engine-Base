package net.darmo_creations.engine_3d.math;

/**
 * Cette classe représente une dimension en 3D.
 * 
 * @author Damien Vergnet
 */
public class Dimension3f {
  private float width, height, length;

  public Dimension3f(Dimension2f d, float length) {
    this(d.getWidth(), d.getHeight(), length);
  }

  /**
   * Crée une dimension 3D.
   * 
   * @param width la largeur
   * @param height la hauteur
   * @param length la longeur
   */
  public Dimension3f(float width, float height, float length) {
    this.width = width;
    this.height = height;
    this.length = length;
  }

  /**
   * @return la largeur
   */
  public float getWidth() {
    return this.width;
  }

  /**
   * Modifie la largeur.
   * 
   * @param width la nouvelle valeur
   */
  public void setWidth(float width) {
    this.width = width;
  }

  /**
   * @return la hauteur
   */
  public float getHeight() {
    return this.height;
  }

  /**
   * Modifie la hauteur.
   * 
   * @param height la nouvelle valeur
   */
  public void setHeight(float height) {
    this.height = height;
  }

  /**
   * @return la longueur
   */
  public float getLength() {
    return this.length;
  }

  /**
   * Modifie la longueur.
   * 
   * @param length la nouvelle valeur
   */
  public void setLength(float length) {
    this.length = length;
  }
}
