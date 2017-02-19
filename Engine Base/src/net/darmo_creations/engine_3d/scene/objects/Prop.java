package net.darmo_creations.engine_3d.scene.objects;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public abstract class Prop implements EngineComponent {
  protected Color color;
  protected Vector3f rotation;
  protected Point3f origin;

  public Prop(Point3f origin, Vector3f rotation) {
    this.origin = origin.clone();
    this.rotation = rotation.clone();
    this.color = Color.white;
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
   * @return a copy of this prop's color
   */
  public Color getColor() {
    return new Color(this.color);
  }

  public void setColor(Color color) {
    this.color = new Color(color);
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
