package net.darmo_creations.engine_3d.scene.objects;

import static net.darmo_creations.engine_3d.utils.RenderUtils.*;

import net.darmo_creations.engine_3d.math.Axis;
import net.darmo_creations.engine_3d.math.Dimension3f;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.utils.MathUtils;

public class Parallelepiped extends Prop {
  private Dimension3f size;
  private float angleX, angleY, angleZ;

  public Parallelepiped(Point3f origin, Dimension3f size, float angleX, float angleY, float angleZ, Vector3f rotation) {
    super(origin, rotation);
    this.size = size;
    this.angleX = angleX;
    this.angleY = angleY;
    this.angleZ = angleZ;
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
    Vector3f length = this.size.getLengthVector();
    Vector3f width = this.size.getWidthVector().rotate(MathUtils.PI_HALF - this.angleY, Axis.Y);
    Vector3f height = this.size.getHeightVector().rotate(-MathUtils.PI_HALF + this.angleX, Axis.X).rotate(-MathUtils.PI_HALF + this.angleZ, Axis.Z);
    Point3f a = this.origin;
    Point3f b = a.clone().add(length);
    Point3f c = a.clone().add(length).add(width);
    Point3f d = a.clone().add(width);
    Point3f e = a.clone().add(height);
    Point3f f = a.clone().add(length).add(height);
    Point3f g = a.clone().add(length).add(width).add(height);
    Point3f h = a.clone().add(width).add(height);

    drawBorderedQuad(a, d, c, b, this.fillColor, this.borderColor);
    drawBorderedQuad(a, b, f, e, this.fillColor, this.borderColor);
    drawBorderedQuad(b, c, g, f, this.fillColor, this.borderColor);
    drawBorderedQuad(c, d, h, g, this.fillColor, this.borderColor);
    drawBorderedQuad(d, a, e, h, this.fillColor, this.borderColor);
    drawBorderedQuad(e, f, g, h, this.fillColor, this.borderColor);
  }
}
