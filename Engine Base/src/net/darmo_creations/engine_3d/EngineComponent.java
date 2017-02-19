package net.darmo_creations.engine_3d;

/**
 * A component can be rendered and updated.
 * 
 * @author Damien Vergnet
 */
public interface EngineComponent {
  /**
   * Updates this component.
   */
  void update();

  /**
   * Renders this component.
   */
  void render();
}
