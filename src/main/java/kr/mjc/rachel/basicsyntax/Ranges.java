package kr.mjc.rachel.basicsyntax;

public class Ranges {
  public static void main(String[] args) {
    for (int x = 0; x <= 10; x++) {
      System.out.print(x);
    }
    System.out.println();

    for (int x = 0; x < 10; x++) {
      System.out.print(x);
    }
    System.out.println();

    for (int x = 1; x <= 10; x += 2) {
      System.out.print(x);
    }
    System.out.println();

    for (int x = 9; x >= 0; x -= 3) {
      System.out.print(x);
    }
    System.out.println();
  }
}
