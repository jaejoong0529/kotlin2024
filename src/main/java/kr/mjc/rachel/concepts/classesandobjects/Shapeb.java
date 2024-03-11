package kr.mjc.rachel.concepts.classesandobjects;

public class Shapeb {
  private final int vertexCount = 0;

  public int getVertexCount() {
    return vertexCount;
  }
}

final class Rectangleb extends Shapeb {
  private final int vertexCount = 4;

  @Override
  public int getVertexCount() {
    return vertexCount;
  }
}
