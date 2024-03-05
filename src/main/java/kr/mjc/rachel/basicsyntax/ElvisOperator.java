package kr.mjc.rachel.basicsyntax;

public class ElvisOperator {
  public static void main(String[] args) {
    String b = "abc";
    int l = (b != null) ? b.length() : -1;
    System.out.println(l);
  }
}
