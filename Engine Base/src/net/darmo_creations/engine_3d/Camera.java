package net.darmo_creations.engine_3d;

import static net.darmo_creations.engine_3d.utils.KeyboardUtils.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;

import net.darmo_creations.engine_3d.math.Vector2f;
import net.darmo_creations.engine_3d.math.Vector3f;

/**
 * A camera has a position, a rotation and an FOV.
 * 
 * @author Damien Vergnet
 */
public class Camera implements EngineComponent {
  private static final float SPRINT_COEF = 1.5f;

  /** Field of view */
  private float fov;
  /** Minimum render distance */
  private float zNear;
  /** Maximum render distance */
  private float zFar;
  /** Camera's position */
  private Vector3f position;
  /** Camera's rotation */
  private Vector2f rotation;
  private Vector3f speed;
  private Vector3f dir;
  private float speedCoef;

  /**
   * Creates a new camera at (0, 0, 0);
   */
  public Camera() {
    this(new Vector3f());
  }

  /**
   * Creates a new camera at the given position.
   * 
   * @param position the position
   */
  public Camera(Vector3f position) {
    this.position = new Vector3f(position);
    this.rotation = new Vector2f();
    this.speed = new Vector3f();
    this.dir = new Vector3f();
    this.speedCoef = 0.1f;
  }

  /**
   * Sets camera's projection.
   * 
   * @param fov field of view
   * @param zNear minimum render distance
   * @param zFar maximum render distance
   */
  public void setProjection(float fov, float zNear, float zFar) {
    this.fov = fov;
    this.zNear = zNear;
    this.zFar = zFar;
  }

  /**
   * Enable camera's projection.
   */
  public void enableProjection() {
    glEnable(GL_PROJECTION);
    glLoadIdentity();
    GLU.gluPerspective(this.fov, (float) Display.getWidth() / Display.getHeight(), this.zNear, this.zFar);
    glEnable(GL_MODELVIEW);
  }

  /**
   * @return this camera's position
   */
  public Vector3f getPosition() {
    return new Vector3f(this.position);
  }

  /**
   * Sets the position
   * 
   * @param position the new location
   */
  public void setPosition(Vector3f position) {
    this.position = new Vector3f(position);
  }

  @Override
  public void update() {
    this.dir.mult(0);

    this.rotation.addX(-Mouse.getDY() * .4f);
    this.rotation.addY(Mouse.getDX() * .4f);

    if (this.rotation.getX() > 90)
      this.rotation.setX(90);
    if (this.rotation.getX() < -90)
      this.rotation.setX(-90);

    if (isForwardKeyPressed())
      this.dir.setZ(-this.speedCoef);
    if (isBackwardKeyPressed())
      this.dir.setZ(this.speedCoef);
    if (isLeftKeyPressed())
      this.dir.setX(-this.speedCoef);
    if (isRightKeyPressed())
      this.dir.setX(this.speedCoef);
    if (isUpKeyPressed())
      this.dir.setY(0.3f);
    if (isDownKeyPressed())
      this.dir.setY(-0.3f);
    else if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
      this.dir.setX(this.dir.getX() * SPRINT_COEF);
      this.dir.setZ(this.dir.getZ() * SPRINT_COEF);
    }

    this.speed.add(new Vector3f( //
        (float) (this.dir.getX() * Math.cos(Math.toRadians(this.rotation.getY())) - this.dir.getZ() * Math.sin(Math.toRadians(this.rotation.getY()))), //
        this.dir.getY(), //
        (float) (this.dir.getZ() * Math.cos(Math.toRadians(this.rotation.getY())) + this.dir.getX() * Math.sin(Math.toRadians(this.rotation.getY())))) //
    );

    this.position.add(this.speed);
    this.speed.mult(0.9f);
  }

  @Override
  public void render() {
    glPushAttrib(GL_TRANSFORM_BIT);
    glRotatef(this.rotation.getX(), 1, 0, 0);
    glRotatef(this.rotation.getY(), 0, 1, 0);
    glTranslatef(-this.position.getX(), -this.position.getY(), -this.position.getZ());
  }
}
