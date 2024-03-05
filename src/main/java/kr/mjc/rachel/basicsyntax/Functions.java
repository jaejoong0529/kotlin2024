package kr.mjc.rachel.basicsyntax;

public class Functions {
  public static int sum(int a, int b) {
    return a + b;
  }

  public static void printSum(int a, int b) {
    System.out.format("sum of %d and %d is %d\n", a, b, a + b);
  }

  public static void main(String[] args) {
    System.out.format("sum of 3 and 5 is %d\n", sum(3, 5));
    printSum(10, 20);
  }
}
