package net.darmo_creations.engine_3d.scene;

public abstract class Animation {
  boolean paused;

  public Animation() {
    this.paused = false;
  }

  public boolean isPaused() {
    return this.paused;
  }

  public void play() {
    this.paused = false;
  }

  public void pause() {
    this.paused = true;
  }

  public final void update() {
    if (!isPaused())
      doUpdate();
  }

  public abstract void doUpdate();
}
