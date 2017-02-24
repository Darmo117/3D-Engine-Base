package net.darmo_creations.engine_3d.scene;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;

public abstract class LocatedObject implements EngineComponent {
  protected Point3f position;
  protected Animation animation;

  public LocatedObject(Point3f position) {
    this.position = position;
  }

  public Point3f getPosition() {
    return this.position.clone();
  }

  public void setPosition(Point3f position) {
    this.position = position.clone();
  }

  public Animation getAnimation() {
    return this.animation;
  }

  public void setAnimation(Animation animation) {
    this.animation = animation;
  }

  @Override
  public void update() {}

  @Override
  public void render() {}
}