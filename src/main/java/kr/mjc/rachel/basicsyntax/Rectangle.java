package kr.mjc.rachel.basicsyntax;

public class Rectangle extends Shape {
  private final double height;
  private final double length;
  private final double perimeter;

  public Rectangle(double height, double length) {
    this.height = height;
    this.length = length;
    this.perimeter = (height + length) * 2;
    System.out.println("a rectangle instance is created.");
  }

  public double getHeight() { // property height
    return height;
  }

  public double getLength() { // property length
    return length;
  }

  public double getPerimeter() {  // property perimeter
    return perimeter;
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(5.0, 2.0);
    System.out.println("The perimeter is " + rectangle.getPerimeter());
  }
}
