package net.darmo_creations.engine_3d.utils;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.math.Point3f;

/**
 * This class provides methods to render objects.
 * 
 * @author Damien Vergnet
 */
public class RenderUtils {
  /**
   * Draws a bordered polygon.
   */
  public static void drawBorderedQuad(Point3f p1, Point3f p2, Point3f p3, Point3f p4, Color faceColor, Color lineColor) {
    drawQuad(p1, p2, p3, p4, faceColor);

    drawLine(p1, p2, lineColor);
    drawLine(p2, p3, lineColor);
    drawLine(p3, p4, lineColor);
    drawLine(p4, p1, lineColor);
  }

  /**
   * Draws a polygon.
   */
  public static void drawQuad(Point3f p1, Point3f p2, Point3f p3, Point3f p4, Color color) {
    GL11.glColor4f(color.r, color.g, color.b, color.a);
    glBegin(GL_QUADS);

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
    GL11.glColor4f(color.r, color.g, color.b, color.a);
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
  private static void vertex(Point3f p) {
    glVertex3f(p.getX(), p.getY(), p.getZ());
  }

  private RenderUtils() {}
}