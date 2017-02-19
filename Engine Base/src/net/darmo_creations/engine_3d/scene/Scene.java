package net.darmo_creations.engine_3d.scene;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.scene.objects.Plane;
import net.darmo_creations.engine_3d.scene.objects.Prop;
import net.darmo_creations.engine_3d.scene.objects.Sphere;

public class Scene implements EngineComponent {
  private List<Prop> props;

  public Scene() {
    this.props = new ArrayList<>();
    // TEMP
    this.props.add(new Plane(new Point3f(0, 0, -100), new Dimension2f(100, 100), new Vector3f(0, 0, 45)));
    this.props.get(0).setColor(Color.green);
    this.props.add(new Sphere(new Point3f(-50, 0, -100), 10, new Vector3f()));
    this.props.get(1).setColor(Color.cyan);
  }

  public boolean addProp(Prop prop) {
    if (prop != null)
      return this.props.add(prop);
    return false;
  }

  public boolean removeProp(Prop prop) {
    return this.props.remove(prop);
  }

  @Override
  public void update() {
    this.props.forEach(Prop::update);
  }

  @Override
  public void render() {
    this.props.forEach(Prop::render);
  }
}
