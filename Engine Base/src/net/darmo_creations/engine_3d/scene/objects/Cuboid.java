package net.darmo_creations.engine_3d.scene.objects;

import net.darmo_creations.engine_3d.math.Dimension3f;
import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public class Cuboid extends Parallelepiped {
  public Cuboid(Point3f origin, Dimension3f size, Vector3f rotation) {
    super(origin, size, MathUtils.HALF_PI, MathUtils.HALF_PI, MathUtils.HALF_PI, rotation);
  }
}
