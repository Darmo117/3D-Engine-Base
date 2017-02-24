package net.darmo_creations.engine_3d.scene;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Color;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.scene.objects.Prop;

public class Scene implements EngineComponent {
  private Map<String, Prop> props;
  private Light[] lights;

  public Scene() {
    this.props = new HashMap<>();
    this.lights = new Light[LightId.availableLightsNb()];
    for (int i = 0; i < this.lights.length; i++)
      this.lights[i] = new Light(LightId.fromIndex(i), new Point3f());
  }

  public void addProp(String name, Prop prop) {
    this.props.put(name, prop);
  }

  public Prop removeProp(String name) {
    return this.props.remove(name);
  }

  public Prop getProp(String name) {
    return this.props.get(name);
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

  public void setLightColor(LightId id, Color diffuseColor, Color ambiantColor, Color specularColor) {
    this.lights[id.ordinal()].setColor(diffuseColor, ambiantColor, specularColor);
  }

  @Override
  public void update() {
    this.props.forEach((name, prop) -> prop.update());
    for (Light light : this.lights)
      light.update();
  }

  @Override
  public void render() {
    this.props.forEach((name, prop) -> prop.render());
    for (Light light : this.lights)
      light.render();
  }
}
