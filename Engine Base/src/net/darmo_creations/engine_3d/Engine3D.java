package net.darmo_creations.engine_3d;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Dimension;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
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

  // ----------- Variables added for Lighting Test -----------//
  private FloatBuffer matSpecular;
  private FloatBuffer lightPosition;
  private FloatBuffer whiteLight;
  private FloatBuffer lModelAmbient;
  // ----------- END: Variables added for Lighting Test -----------//

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

    this.cam.setProjection();

    glMatrixMode(GL_MODELVIEW);

    glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

    // Variables and method calls added for lighting.
    initLightArrays();
    glShadeModel(GL_SMOOTH);
    // Sets specular material color
    glMaterial(GL_FRONT, GL_SPECULAR, this.matSpecular);
    // Sets shininess
    glMaterialf(GL_FRONT, GL_SHININESS, 50);

    // Sets light position
    glLight(GL_LIGHT0, GL_POSITION, this.lightPosition);
    // Sets specular light to white
    glLight(GL_LIGHT0, GL_SPECULAR, this.whiteLight);
    // Sets diffuse light to white
    glLight(GL_LIGHT0, GL_DIFFUSE, this.whiteLight);
    // Global ambient light
    glLightModel(GL_LIGHT_MODEL_AMBIENT, this.lModelAmbient);

    // Enables lighting
    glEnable(GL_LIGHTING);
    // Enables light0
    glEnable(GL_LIGHT0);

    // Enables opengl to use glColor3f to define material color
    glEnable(GL_COLOR_MATERIAL);
    // Tell opengl glColor3f effects the ambient and diffuse properties of material
    glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);

    glEnable(GL_CULL_FACE);
    glCullFace(GL_FRONT);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    loop();
  }

  private void initLightArrays() {
    this.matSpecular = BufferUtils.createFloatBuffer(4);
    this.matSpecular.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();

    this.lightPosition = BufferUtils.createFloatBuffer(4);
    this.lightPosition.put(1.0f).put(1.0f).put(1.0f).put(0.0f).flip();

    this.whiteLight = BufferUtils.createFloatBuffer(4);
    this.whiteLight.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();

    this.lModelAmbient = BufferUtils.createFloatBuffer(4);
    this.lModelAmbient.put(0.5f).put(0.5f).put(0.5f).put(1.0f).flip();
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
    glLoadIdentity();

    this.cam.render();
    this.scene.render();
  }
}
