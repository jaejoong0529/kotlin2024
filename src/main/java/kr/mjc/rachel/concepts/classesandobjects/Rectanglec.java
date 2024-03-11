package kr.mjc.rachel.concepts.classesandobjects;

public class Rectanglec {
  private final int width;
  private final int height;

  public Rectanglec(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public final int getWidth() {
    return width;
  }

  public final int getHeight() {
    return height;
  }

  public final int getArea() {
    return this.width + this.height;
  }
}
