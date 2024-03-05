package kr.mjc.rachel.basicsyntax;

public class ConditionalExpressions {
  public static int maxOf(int a, int b) {
    return a >= b ? a : b;
  }

  public static void main(String[] args) {
    System.out.println("max of 0 and 42 is " + maxOf(0, 42));
  }
}
