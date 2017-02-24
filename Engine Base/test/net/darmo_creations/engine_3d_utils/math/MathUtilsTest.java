package net.darmo_creations.engine_3d_utils.math;

import static net.darmo_creations.engine_3d.math.MathUtils.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MathUtilsTest {
  @Test
  public void testUnsignedByte() {
    assertEquals(255, getUnsignedByte((byte) 255));
  }

  @Test
  public void testMap() {
    assertEquals(0.5f, map(2, 0, 4, 0, 1), 0);
  }
}
