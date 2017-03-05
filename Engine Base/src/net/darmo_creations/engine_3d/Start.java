package net.darmo_creations.engine_3d;

import static net.darmo_creations.engine_3d.utils.Logger.*;

import java.util.Date;

import net.darmo_creations.engine_3d.utils.CrashReport;

/**
 * Main class.
 * 
 * @author Damien Vergnet
 */
public class Start {
  public static void main(String[] args) {
    beginCatchingOutputs(); // Do NOT move elsewhere.

    boolean error = false;

    getLogger().info(new Date());
    getLogger().info("Starting...");
    try {
      Engine3D.getInstance()
          .start();
    }
    catch (Throwable ex) {
      getLogger().severe("Error or exception caught: " + ex);
      ex.printStackTrace();
      String rep = new CrashReport(ex).saveReport();

      error = true;
      getLogger().info("Error log saved at '" + rep + "'.");
      getLogger().info("Stopping...");
    }

    if (error) {
      getLogger().warning("Terminated with errors.");
    }
    else {
      getLogger().info("Terminated successfully.");
    }
  }
}
