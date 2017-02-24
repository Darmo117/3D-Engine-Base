package net.darmo_creations.engine_3d.scene;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Dimension3f;
import net.darmo_creations.engine_3d.math.MathUtils;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.scene.objects.Cuboid;
import net.darmo_creations.engine_3d.scene.objects.Parallelepiped;
import net.darmo_creations.engine_3d.scene.objects.Plane;
import net.darmo_creations.engine_3d.scene.objects.Prop;
import net.darmo_creations.engine_3d.scene.objects.Sphere;

public class Scene implements EngineComponent {
  private List<Prop> props;
  private Light[] lights;

  public Scene() {
    this.props = new ArrayList<>();

    // TEMP
    this.props.add(new Plane(new Point3f(0, 0, -100), new Dimension2f(100, 100), new Vector3f()));
    this.props.get(0).setFillColor(Color.green);
    this.props.add(new Sphere(new Point3f(-50, 0, -100), new Vector3f(), 10));
    this.props.get(1).setFillColor(Color.cyan);
    // #f:0
    this.props.add(new Parallelepiped(
        new Point3f(0, -50, -100),
        new Dimension3f(20, 20, 20),
        MathUtils.HALF_PI,
        MathUtils.HALF_PI,
        MathUtils.PI / 4,
        new Vector3f()));
    // #f:1
    this.props.get(2).setFillColor(Color.red);
    this.props.add(new Cuboid(new Point3f(-30, -20, -100), new Dimension3f(20, 20, 20), new Vector3f()));
    this.props.get(3).setFillColor(Color.orange);
    // end TEMP

    this.lights = new Light[LightId.availableLightsNb()];
    for (int i = 0; i < this.lights.length; i++)
      this.lights[i] = new Light(LightId.fromIndex(i), new Point3f());
  }

  public boolean addProp(Prop prop) {
    if (prop != null)
      return this.props.add(prop);
    return false;
  }

  public boolean removeProp(Prop prop) {
    return this.props.remove(prop);
  }

  public void setLightEnable(LightId id, boolean enabled) {
    if (enabled)
      this.lights[id.ordinal()].enable();
    else
      this.lights[id.ordinal()].disable();
  }

  public void setLightPos(LightId id, Point3f pos) {
    this.lights[id.ordinal()].setPosition(pos);
  }

  @Override
  public void update() {
    this.props.forEach(Prop::update);
    for (Light light : this.lights)
      light.update();
  }

  @Override
  public void render() {
    this.props.forEach(Prop::render);
    for (Light light : this.lights)
      light.render();
  }
}
