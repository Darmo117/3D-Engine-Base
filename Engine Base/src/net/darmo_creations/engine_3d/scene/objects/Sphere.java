package net.darmo_creations.engine_3d.scene.objects;

import org.lwjgl.opengl.GL11;

import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public class Sphere extends Prop {
  private org.lwjgl.util.glu.Sphere model;
  private float radius;

  public Sphere(Point3f origin, float radius, Vector3f rotation) {
    super(origin, rotation);
    this.radius = radius;
    this.model = new org.lwjgl.util.glu.Sphere();
  }

  public float getRadius() {
    return this.radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }

  @Override
  public void update() {}

  @Override
  protected void doRender() {
    GL11.glColor4f(this.color.r, this.color.g, this.color.b, this.color.a);
    GL11.glTranslatef(this.origin.getX(), this.origin.getY(), this.origin.getZ());
    this.model.draw(this.radius, 100, 100);
  }
}
