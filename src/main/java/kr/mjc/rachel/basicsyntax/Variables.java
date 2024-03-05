package kr.mjc.rachel.basicsyntax;

public class Variables {
  public static void main(String[] args) {
    int a = 1;  // final int a = 1. a는 read only
    int b = 2;  // Type inference (타입 추론) : 2로 b가 Int 라는 것을 추론
    System.out.format("a = %d, b = %d\n", a, b); // String format

    int x = 5; // x는 재할당 가능
    x = 6;
  }
}
