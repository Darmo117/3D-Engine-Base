package net.darmo_creations.engine_3d.scene.objects;

import static net.darmo_creations.engine_3d.utils.RenderUtils.*;

import net.darmo_creations.engine_3d.math.Axis;
import net.darmo_creations.engine_3d.math.Dimension3f;
import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public class Parallelepiped extends Prop {
  private Dimension3f size;
  private float angleX, angleY, angleZ;
  private Point3f a, b, c, d, e, f, g, h;

  public Parallelepiped(Point3f origin, Dimension3f size, float angleX, float angleY, float angleZ, Vector3f rotation) {
    super(origin, rotation);
    this.size = size;
    this.angleX = angleX;
    this.angleY = angleY;
    this.angleZ = angleZ;

    Vector3f length = this.size.getLengthVector();
    Vector3f width = this.size.getWidthVector().rotate(MathUtils.HALF_PI - this.angleY, Axis.Y);
    Vector3f height = this.size.getHeightVector().rotate(-MathUtils.HALF_PI + this.angleX, Axis.X).rotate(-MathUtils.HALF_PI + this.angleZ, Axis.Z);
    this.a = new Point3f();
    this.b = this.a.clone().add(length);
    this.c = this.a.clone().add(length).add(width);
    this.d = this.a.clone().add(width);
    this.e = this.a.clone().add(height);
    this.f = this.a.clone().add(length).add(height);
    this.g = this.a.clone().add(length).add(width).add(height);
    this.h = this.a.clone().add(width).add(height);
  }

  public Dimension3f getSize() {
    return this.size;
  }

  public void setSize(Dimension3f size) {
    this.size = size;
  }

  public float getAngleX() {
    return this.angleX;
  }

  public void setAngleX(float angleX) {
    this.angleX = angleX;
  }

  public float getAngleY() {
    return this.angleY;
  }

  public void setAngleY(float angleY) {
    this.angleY = angleY;
  }

  public float getAngleZ() {
    return this.angleZ;
  }

  public void setAngleZ(float angleZ) {
    this.angleZ = angleZ;
  }

  @Override
  protected void doRender() {
    drawBorderedQuad(this.a, this.d, this.c, this.b, this.fillColor, this.borderColor);
    drawBorderedQuad(this.a, this.b, this.f, this.e, this.fillColor, this.borderColor);
    drawBorderedQuad(this.b, this.c, this.g, this.f, this.fillColor, this.borderColor);
    drawBorderedQuad(this.c, this.d, this.h, this.g, this.fillColor, this.borderColor);
    drawBorderedQuad(this.d, this.a, this.e, this.h, this.fillColor, this.borderColor);
    drawBorderedQuad(this.e, this.f, this.g, this.h, this.fillColor, this.borderColor);
  }
}
