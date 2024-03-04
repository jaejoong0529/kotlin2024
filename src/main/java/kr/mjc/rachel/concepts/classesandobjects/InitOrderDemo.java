package kr.mjc.rachel.concepts.classesandobjects;

public class InitOrderDemo {

  String firstProperty;

  public InitOrderDemo(String name) {
    firstProperty = "First property: " + name;
    System.out.println(firstProperty);
  }

  public String getFirstProperty() {
    return firstProperty;
  }
}
