package kr.mjc.rachel.basicsyntax;

public class WhenExpression {
  public static String describe(Object obj) {
    if (obj.equals(1)) return "One";
    else if (obj.equals("Hello")) return "Greeting";
    else if (obj instanceof Long) return "Long";
    else if (!(obj instanceof String)) return "Not a string";
    else return "Unknown";
  }

  public static void main(String[] args) {
    System.out.println(describe(1));
    System.out.println(describe("Hello"));
    System.out.println(describe(1000L));
    System.out.println(describe(2));
    System.out.println(describe("other"));
  }
}
