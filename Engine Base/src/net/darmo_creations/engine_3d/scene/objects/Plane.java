package net.darmo_creations.engine_3d.scene.objects;

import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.utils.RenderUtils;

public class Plane extends Prop {
  private Dimension2f size;
  private Point3f p1, p2, p3, p4;

  public Plane(Point3f origin, Dimension2f size, Vector3f rotation) {
    super(origin, rotation);
    this.size = size;
    Vector3f w = Vector3f.fromVector2f(this.size.getWidthVector());
    Vector3f h = Vector3f.fromVector2f(this.size.getHeightVector());
    this.p1 = new Point3f();
    this.p2 = this.p1.clone().add(w);
    this.p3 = this.p1.clone().add(w).add(h);
    this.p4 = this.p1.clone().add(h);
  }

  public Dimension2f getSize() {
    return this.size;
  }

  public void setSize(Dimension2f size) {
    this.size = size;
  }

  @Override
  protected void doRender() {
    RenderUtils.drawBorderedQuad(this.p1, this.p2, this.p3, this.p4, this.fillColor, this.borderColor);
    RenderUtils.drawBorderedQuad(this.p1, this.p4, this.p3, this.p2, this.fillColor, this.borderColor);
  }
}
