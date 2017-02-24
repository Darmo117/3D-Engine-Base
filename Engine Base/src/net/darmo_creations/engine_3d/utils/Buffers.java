package net.darmo_creations.engine_3d.utils;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class Buffers {
  public static FloatBuffer floatBuffer(float... data) {
    FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);

    buffer.put(data);
    buffer.flip();

    return buffer;
  }

  private Buffers() {}
}
