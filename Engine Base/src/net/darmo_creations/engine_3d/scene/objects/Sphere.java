package net.darmo_creations.engine_3d.scene.objects;

import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public class Sphere extends Supershape {
  public Sphere(Point3f origin, float radius, Vector3f rotation) {
    super(origin, rotation);
    this.m1 = this.m2 = 0;
    this.n11 = this.n12 = this.n13 = this.n21 = this.n22 = this.n23 = 1;
    setRadius(radius);
  }
}
