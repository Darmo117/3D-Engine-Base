package net.darmo_creations.engine_3d.scene.objects;

import static org.lwjgl.opengl.GL11.*;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public abstract class Prop implements EngineComponent {
  private Vector3f rotation;
  private Point3f origin;

  public Prop(Point3f origin, Vector3f rotation) {
    this.origin = origin;
    this.rotation = new Vector3f(rotation);
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

  public Point3f getOrigin() {
    return this.origin;
  }

  public void setOrigin(Point3f origin) {
    this.origin = origin;
  }

  public Vector3f getRotation() {
    return new Vector3f(this.rotation);
  }

  public void setRotation(Vector3f rotation) {
    this.rotation = rotation;
  }

  /**
   * Does the rendering.
   */
  protected abstract void doRender();
}
