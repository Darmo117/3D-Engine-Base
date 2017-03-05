package net.darmo_creations.engine_3d.scene.objects;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.scene.LocatedObject;

// TODO ne calculer les points q'une seule fois.
public abstract class Prop extends LocatedObject {
  protected Vector3f rotation;
  protected Color fillColor;
  protected Color borderColor;

  public Prop(Point3f position, Vector3f rotation) {
    super(position);
    this.position = position.clone();
    this.rotation = rotation.clone();
    this.fillColor = Color.white;
    this.borderColor = Color.darkGray;
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

  /**
   * @return a copy of this prop's border color
   */
  public Color getBorderColor() {
    return new Color(this.borderColor);
  }

  public void setBorderColor(Color borderColor) {
    this.borderColor = new Color(borderColor);
  }

  @Override
  public void update() {
    if (this.animation != null)
      this.animation.update();
  }

  @Override
  public final void render() {
    glPushMatrix();
    glTranslatef(this.position.getX(), this.position.getY(), this.position.getZ());
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
