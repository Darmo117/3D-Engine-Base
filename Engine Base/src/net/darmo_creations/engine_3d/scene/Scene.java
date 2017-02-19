package net.darmo_creations.engine_3d.scene;

import java.util.ArrayList;
import java.util.List;

import net.darmo_creations.engine_3d.EngineComponent;
import net.darmo_creations.engine_3d.math.Dimension2f;
import net.darmo_creations.engine_3d.math.Point3f;
import net.darmo_creations.engine_3d.math.Vector3f;
import net.darmo_creations.engine_3d.scene.objects.Plane;
import net.darmo_creations.engine_3d.scene.objects.Prop;

public class Scene implements EngineComponent {
  private List<Prop> props;

  public Scene() {
    this.props = new ArrayList<>();
    this.props.add(new Plane(new Point3f(0, 0, -100), new Dimension2f(100, 100), new Vector3f(0, 0, 45)));
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
