package net.darmo_creations.engine_3d.scene;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.utils.Buffers;
import net.darmo_creations.engine_3d.utils.RenderUtils;

/**
 * Light source.
 * 
 * @author Damien Vergnet
 */
public class Light implements EngineComponent {
  private final LightId id;
  private Point3f position;

  public Light(LightId id, Point3f position) {
    this.id = id;
    this.position = position;
  }

  public Point3f getPosition() {
    return this.position.clone();
  }

  public void setPosition(Point3f position) {
    this.position = position.clone();
  }

  public LightId getId() {
    return this.id;
  }

  public void enable() {
    if (!glIsEnabled(this.id.getValue()))
      glEnable(this.id.getValue());
  }

  public void disable() {
    if (glIsEnabled(this.id.getValue()))
      glDisable(this.id.getValue());
  }

  public void setColor(Color diffuseColor, Color ambiantColor, Color specularColor) {
    glLight(this.id.getValue(), GL_DIFFUSE, Buffers.floatBuffer(diffuseColor.r, diffuseColor.g, diffuseColor.g, 1));
    glLight(this.id.getValue(), GL_AMBIENT, Buffers.floatBuffer(ambiantColor.r, ambiantColor.g, ambiantColor.g, 1));
    glLight(this.id.getValue(), GL_SPECULAR, Buffers.floatBuffer(specularColor.r, specularColor.g, specularColor.g, 1));
  }

  @Override
  public void render() {
    glPushMatrix();
    glTranslatef(this.position.getX(), this.position.getY(), this.position.getZ());
    RenderUtils.color3(Color.white);
    new Sphere().draw(2, 50, 50);
    glPopMatrix();
  }

  @Override
  public void update() {
    glLight(this.id.getValue(), GL_POSITION, Buffers.floatBuffer(this.position.getX(), this.position.getY(), this.position.getZ(), 1));
  }
}
