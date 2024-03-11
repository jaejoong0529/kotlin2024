package kr.mjc.rachel.concepts.classesandobjects;

public class Circle {
  private int x;
  private int y;
  private int radius;

  public Circle(int x, int y) {
    this.x = x;
    this.y = y;
    this.radius = 1;
  }

  public final int getX() {
    return x;
  }

  public final void setX(int x) {
    this.x = x;
  }

  public final int getY() {
    return y;
  }

  public final void setY(int y) {
    this.y = y;
  }

  public final int getRadius() {
    return radius;
  }

  public final void setRadius(int value) {
    if (value >= 0) this.radius = value;
    else throw new RuntimeException("반지름이 0 미만");
  }

  @Override
  public String toString() {
    return String.format("Circle{x=%d, y=%d, radius=%d}", x, y, radius);
  }
}
