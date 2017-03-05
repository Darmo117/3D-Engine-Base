package net.darmo_creations.engine_3d.scene.objects;

import org.lwjgl.opengl.GL11;

import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.utils.RenderUtils;

public class Supershape extends Prop {
  private int totalPoints;
  private float radius;
  protected float a, b;
  protected float m1, m2;
  protected float n11, n12, n13, n21, n22, n23;
  private Vector3f[][] points;

  public Supershape(Point3f origin, Vector3f rotation, float radius) {
    this(origin, rotation, radius, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1);
  }

  public Supershape(Point3f origin, Vector3f rotation, float radius, float a, float b, float m1, float m2, float n11, float n12, float n13, float n21,
      float n22, float n23) {
    super(origin, rotation);
    this.totalPoints = 75;
    this.radius = radius;
    this.a = a;
    this.b = b;
    this.m1 = m1;
    this.m2 = m2;
    this.n11 = n11;
    this.n12 = n12;
    this.n13 = n13;
    this.n21 = n21;
    this.n22 = n22;
    this.n23 = n23;
    this.points = new Vector3f[this.totalPoints + 1][this.totalPoints + 1];

    for (int i = 0; i < this.totalPoints + 1; i++) {
      float lat = MathUtils.map(i, 0, this.totalPoints, -MathUtils.HALF_PI, MathUtils.HALF_PI);
      float r2 = compute(lat, this.m2, this.n21, this.n22, this.n23);

      for (int j = 0; j < this.totalPoints + 1; j++) {
        float lon = MathUtils.map(j, 0, this.totalPoints, -MathUtils.PI, MathUtils.PI);
        float r1 = compute(lon, this.m1, this.n11, this.n12, this.n13);
        float x = this.radius * r1 * MathUtils.cos(lon) * r2 * MathUtils.cos(lat);
        float y = this.radius * r1 * MathUtils.sin(lon) * r2 * MathUtils.cos(lat);
        float z = this.radius * r2 * MathUtils.sin(lat);

        this.points[i][j] = new Vector3f(x, y, z);
      }
    }

  }

  public float getRadius() {
    return this.radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }

  public float getA() {
    return this.a;
  }

  public void setA(float a) {
    this.a = a;
  }

  public float getB() {
    return this.b;
  }

  public void setB(float b) {
    this.b = b;
  }

  public float getM1() {
    return this.m1;
  }

  public void setM1(float m1) {
    this.m1 = m1;
  }

  public float getM2() {
    return this.m2;
  }

  public void setM2(float m2) {
    this.m2 = m2;
  }

  public float getN11() {
    return this.n11;
  }

  public void setN11(float n11) {
    this.n11 = n11;
  }

  public float getN12() {
    return this.n12;
  }

  public void setN12(float n12) {
    this.n12 = n12;
  }

  public float getN13() {
    return this.n13;
  }

  public void setN13(float n13) {
    this.n13 = n13;
  }

  public float getN21() {
    return this.n21;
  }

  public void setN21(float n21) {
    this.n21 = n21;
  }

  public float getN22() {
    return this.n22;
  }

  public void setN22(float n22) {
    this.n22 = n22;
  }

  public float getN23() {
    return this.n23;
  }

  public void setN23(float n23) {
    this.n23 = n23;
  }

  @Override
  protected void doRender() {
    // TODO calculer les normales pour l'éclairage.
    RenderUtils.color4(this.fillColor);
    for (int i = 0; i < this.totalPoints; i++) {
      GL11.glBegin(GL11.GL_TRIANGLE_STRIP);
      for (int j = 0; j < this.totalPoints + 1; j++) {
        Vector3f v1 = this.points[i][j];
        RenderUtils.vertex(v1.getX(), v1.getY(), v1.getZ());
        if (i < this.totalPoints) {
          Vector3f v2 = this.points[i + 1][j];
          RenderUtils.vertex(v2.getX(), v2.getY(), v2.getZ());
        }
      }
      GL11.glEnd();
    }
  }

  private float compute(float angle, float m, float n1, float n2, float n3) {
    float t1 = MathUtils.pow(Math.abs(1 / this.a * MathUtils.cos(m * angle / 4)), n2);
    float t2 = MathUtils.pow(Math.abs(1 / this.b * MathUtils.sin(m * angle / 4)), n3);
    return MathUtils.pow(t1 + t2, -1 / n1);
  }
}
