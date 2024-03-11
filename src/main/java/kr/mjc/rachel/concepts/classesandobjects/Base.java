package kr.mjc.rachel.concepts.classesandobjects;

public class Base {
  private final int p;

  public Base(int p) {
    this.p = p;
  }

  public int getP() {
    return p;
  }
}

class Derived extends Base {
  public Derived(int p) {
    super(p);
  }
}