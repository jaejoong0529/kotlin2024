package kr.mjc.rachel.basics;

public class CircleTest {
  public static void main(String[] args) {
    Circle c1 = new Circle(0, 0, 1);
    Circle c2 = new Circle(1, 1, 10);

    System.out.println(Circle.PI);
    System.out.println(c1.getX());
    System.out.println(c2.getX());
  }
}
