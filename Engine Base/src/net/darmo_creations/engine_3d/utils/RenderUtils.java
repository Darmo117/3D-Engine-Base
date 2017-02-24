package net.darmo_creations.engine_3d.utils;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

/**
 * This class provides methods to render objects.
 * 
 * @author Damien Vergnet
 */
public class RenderUtils {
  public static void color4(Color color) {
    GL11.glColor4f(color.r, color.g, color.b, color.a);
  }

  public static void color3(Color color) {
    GL11.glColor3f(color.r, color.g, color.b);
  }

  /**
   * Draws a bordered quad.
   */
  public static void drawBorderedQuad(Point3f p1, Point3f p2, Point3f p3, Point3f p4, Color fillColor, Color borderColor) {
    drawQuad(p1, p2, p3, p4, fillColor);

    drawLine(p1, p2, borderColor);
    drawLine(p2, p3, borderColor);
    drawLine(p3, p4, borderColor);
    drawLine(p4, p1, borderColor);
  }

  /**
   * Draws a quad.
   */
  public static void drawQuad(Point3f p1, Point3f p2, Point3f p3, Point3f p4, Color color) {
    color4(color);
    glBegin(GL_QUADS);

    Vector3f n = MathUtils.normal(p1, p2, p3);
    GL11.glNormal3f(n.getX(), n.getY(), n.getZ());
    vertex(p1);
    vertex(p2);
    vertex(p3);
    vertex(p4);

    glEnd();
  }

  /**
   * Draws a line from p1 to p2.
   */
  public static void drawLine(Point3f p1, Point3f p2, Color color) {
    color4(color);
    glBegin(GL_LINE_STRIP);

    vertex(p1);
    vertex(p2);

    glEnd();
  }

  /**
   * Declares a vertex.
   * 
   * @param p the vertex coordinates
   */
  public static void vertex(Point3f p) {
    vertex(p.getX(), p.getY(), p.getZ());
  }

  /**
   * Declares a vertex.
   * 
   * @param x the vertex coordinates
   * @param y the vertex coordinates
   * @param z the vertex coordinates
   */
  public static void vertex(float x, float y, float z) {
    glVertex3f(x, y, z);
  }

  private RenderUtils() {}
}
