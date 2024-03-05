package kr.mjc.rachel.basicsyntax;

public class SafeCalls {
  public static void main(String[] args) {
    String a = "abc";
    String b = "abc";
    b = null;
    System.out.println(b);

    System.out.println("a.length = " + a.length());
    System.out.println("b.length = " + ((b != null) ? b.length() : null));
  }
}
