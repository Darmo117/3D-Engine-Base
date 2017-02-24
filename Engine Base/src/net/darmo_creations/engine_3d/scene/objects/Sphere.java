package net.darmo_creations.engine_3d.scene.objects;

import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;

public class Sphere extends Supershape {
  public Sphere(Point3f origin, Vector3f rotation, float radius) {
    super(origin, rotation, radius);
    this.m1 = this.m2 = 0;
    this.n11 = this.n12 = this.n13 = this.n21 = this.n22 = this.n23 = 1;
  }
}
