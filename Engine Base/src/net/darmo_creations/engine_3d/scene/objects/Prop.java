package net.darmo_creations.engine_3d.scene.objects;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public abstract class Prop implements EngineComponent {
  protected Color fillColor;
  protected Color borderColor;
  protected Vector3f rotation;
  protected Point3f origin;

  public Prop(Point3f origin, Vector3f rotation) {
    this.origin = origin.clone();
    this.rotation = rotation.clone();
    this.fillColor = Color.white;
    this.borderColor = Color.darkGray;
  }

  public Point3f getOrigin() {
    return this.origin.clone();
  }

  public void setOrigin(Point3f origin) {
    this.origin = origin.clone();
  }

  public Vector3f getRotation() {
    return this.rotation.clone();
  }

  public void setRotation(Vector3f rotation) {
    this.rotation = rotation.clone();
  }

  /**
   * @return a copy of this prop's fill color
   */
  public Color getFillColor() {
    return new Color(this.fillColor);
  }

  public void setFillColor(Color fillColor) {
    this.fillColor = new Color(fillColor);
  }

  public Color getBorderColor() {
    return new Color(this.borderColor);
  }

  public void setBorderColor(Color borderColor) {
    this.borderColor = new Color(borderColor);
  }

  @Override
  public final void render() {
    glPushMatrix();
    glRotatef(this.rotation.getX(), 1, 0, 0);
    glRotatef(this.rotation.getY(), 0, 1, 0);
    glRotatef(this.rotation.getZ(), 0, 0, 1);
    doRender();
    glPopMatrix();
  }

  /**
   * Does the rendering.
   */
  protected abstract void doRender();
}
