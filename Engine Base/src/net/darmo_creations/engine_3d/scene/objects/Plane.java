package net.darmo_creations.engine_3d.scene.objects;

import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.utils.RenderUtils;

public class Plane extends Prop {
  private Dimension2f size;

  public Plane(Point3f origin, Dimension2f size, Vector3f rotation) {
    super(origin, rotation);
    this.size = size;
  }

  public Dimension2f getSize() {
    return this.size;
  }

  public void setSize(Dimension2f size) {
    this.size = size;
  }

  @Override
  protected void doRender() {
    Point3f origin = new Point3f();
    Vector3f w = Vector3f.fromVector2f(this.size.getWidthVector());
    Vector3f h = Vector3f.fromVector2f(this.size.getHeightVector());
    Point3f p2 = origin.clone().add(w);
    Point3f p3 = origin.clone().add(w).add(h);
    Point3f p4 = origin.clone().add(h);

    RenderUtils.drawBorderedQuad(origin, p2, p3, p4, this.fillColor, this.borderColor);
    RenderUtils.drawBorderedQuad(origin, p4, p3, p2, this.fillColor, this.borderColor);
  }
}
