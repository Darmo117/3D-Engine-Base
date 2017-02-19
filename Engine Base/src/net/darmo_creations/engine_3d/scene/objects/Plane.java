package net.darmo_creations.engine_3d.scene.objects;

import org.newdawn.slick.Color;

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

  @Override
  public void update() {}

  @Override
  protected void doRender() {
    Vector3f w = Vector3f.fromVector2f(this.size.getWidthVector());
    Vector3f h = Vector3f.fromVector2f(this.size.getHeightVector());
    Point3f o = getOrigin();
    Point3f p2 = o.add(w);
    Point3f p3 = o.add(w).add(h);
    Point3f p4 = o.add(h);

    RenderUtils.drawQuad(o, p2, p3, p4, Color.blue);
  }
}
