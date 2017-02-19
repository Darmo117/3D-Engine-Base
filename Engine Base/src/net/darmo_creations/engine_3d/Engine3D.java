package net.darmo_creations.engine_3d;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

import net.darmo_creations.engine_3d.scene.Scene;
import net.darmo_creations.engine_3d.utils.MouseUtils;

/**
 * Le moteur 3D.
 * 
 * @author Damien Vergnet
 */
public class Engine3D implements EngineComponent {
  private static final int TPS = 60;

  private static Engine3D theEngine;

  /**
   * @return l'instance unique du moteur (créée si inexistante)
   */
  public static Engine3D getInstance() {
    if (theEngine == null)
      theEngine = new Engine3D();
    return theEngine;
  }

  private Camera cam;
  private Scene scene;
  private Dimension viewportSize;

  /**
   * Crée une nouvelle instance du moteur.
   */
  private Engine3D() {
    this.cam = new Camera();
    this.cam.setProjection(80, .01f, 10000);
    this.scene = new Scene();
    this.viewportSize = new Dimension(800, 600);
  }

  public void start() {
    try {
      Display.setDisplayMode(new DisplayMode(this.viewportSize.width, this.viewportSize.height));
      Display.create(new PixelFormat(0, 8, 0, 4));
    }
    catch (LWJGLException ex) {
      throw new RuntimeException(ex);
    }

    glMatrixMode(GL_MODELVIEW);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    glEnable(GL_DEPTH_TEST);
    loop();
  }

  /**
   * Main loop.
   */
  private void loop() {
    final double NANO = 1e9 / TPS;
    long before = System.nanoTime();

    while (!Display.isCloseRequested()) {
      long now = System.nanoTime();
      double elapsed = now - before;

      if (elapsed > NANO) {
        update();
        before += NANO;
      }
      render();

      Display.update();
    }

    Display.destroy();
  }

  public Dimension getViewportSize() {
    return new Dimension(this.viewportSize);
  }

  public void setViewportSize(int width, int height) {
    this.viewportSize.setSize(width, height);
  }

  public boolean isEnginePaused() {
    return !Mouse.isGrabbed();
  }

  @Override
  public void update() {
    if (MouseUtils.isLeftButtonDown())
      Mouse.setGrabbed(true);
    if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
      Mouse.setGrabbed(false);

    if (!isEnginePaused()) {
      this.cam.update();
      this.scene.update();
    }
  }

  @Override
  public void render() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glViewport(0, 0, this.viewportSize.width, this.viewportSize.height);

    this.cam.enableProjection();
    this.cam.render();
    this.scene.render();
  }
}
