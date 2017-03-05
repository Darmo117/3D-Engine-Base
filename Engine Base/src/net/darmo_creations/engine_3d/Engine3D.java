package net.darmo_creations.engine_3d;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Dimension3f;
import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.scene.LightId;
import net.darmo_creations.engine_3d.scene.Scene;
import net.darmo_creations.engine_3d.scene.objects.Cuboid;
import net.darmo_creations.engine_3d.scene.objects.Parallelepiped;
import net.darmo_creations.engine_3d.scene.objects.Plane;
import net.darmo_creations.engine_3d.scene.objects.Sphere;
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
    this.cam = new Camera(new Point3f(0, 10, 0));
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

    // Sets background to grey
    glClearColor(0.5f, 0.5f, 0.5f, 0);
    // Clear depth buffer
    glClearDepth(1);
    // Enables depth testing
    glEnable(GL_DEPTH_TEST);
    // Sets the type of test to use for depth testing
    glDepthFunc(GL_LEQUAL);
    // Sets the matrix mode to project
    glMatrixMode(GL_PROJECTION);

    this.cam.setPerspective();

    glMatrixMode(GL_MODELVIEW);

    glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

    // Enables lighting
    glEnable(GL_LIGHTING);
    // Enables light0 (default at (0, 0, 0))
    glLightModeli(GL_LIGHT_MODEL_TWO_SIDE, GL_TRUE);
    // Enables the use of glColorXf to define material color
    glEnable(GL_COLOR_MATERIAL);
    // Tell OpenGL glColorXf effects the ambient and diffuse properties of material
    glColorMaterial(GL_FRONT_AND_BACK, GL_AMBIENT_AND_DIFFUSE);

    glEnable(GL_CULL_FACE);
    glCullFace(GL_FRONT);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

    loop();
  }

  /**
   * Main loop.
   */
  private void loop() {
    final double NANO = 1e9 / TPS;
    long before = System.nanoTime();

    // TEMP
    this.scene.setLightEnable(LightId.LIGHT_0, true);
    this.scene.setLightPos(LightId.LIGHT_0, new Point3f(0, 20, 0));
    this.scene.setLightColor(LightId.LIGHT_0, Color.white, new Color(0.1f, 0.1f, 0.1f), Color.white);
    this.scene.setRenderLights(true);

    this.scene.addProp("plane", new Plane(new Point3f(-200, 0, 200), new Dimension2f(400, 400), new Vector3f(-90, 0, 0)));
    this.scene.getProp("plane").setFillColor(Color.green);
    this.scene.addProp("sphere", new Sphere(new Point3f(-50, 0, -100), new Vector3f(), 10));
    this.scene.getProp("sphere").setFillColor(Color.cyan);
    this.scene.addProp("box", new Parallelepiped(new Point3f(0, 0, -100), new Dimension3f(20, 20, 20), MathUtils.HALF_PI, MathUtils.HALF_PI,
        MathUtils.PI / 4, new Vector3f()));
    this.scene.getProp("box").setFillColor(Color.red);
    this.scene.addProp("parallelogram", new Cuboid(new Point3f(-30, 0, -100), new Dimension3f(20, 20, 20), new Vector3f()));
    this.scene.getProp("parallelogram").setFillColor(Color.orange);
    // end TEMP

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
    if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || Keyboard.isKeyDown(Keyboard.KEY_TAB))
      Mouse.setGrabbed(false);

    if (!isEnginePaused()) {
      this.cam.update();
      this.scene.update();
    }
  }

  @Override
  public void render() {
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();

    this.cam.render();
    this.scene.render();
  }
}
