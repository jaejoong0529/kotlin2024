package kr.mjc.rachel.basics;

public class Rectangle extends Shape {
  private double height;
  private double length;
  private double perimeter;

  public Rectangle(double height, double length) {
    this.height = height;
    this.length = length;
    this.perimeter = (height + length) * 2;
    System.out.println("a rectangle instance is created.");
  }

  public double getPerimeter() {
    return perimeter;
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(5.0, 2.0);
    System.out.println("The perimeter is " + rectangle.getPerimeter());
  }
}
