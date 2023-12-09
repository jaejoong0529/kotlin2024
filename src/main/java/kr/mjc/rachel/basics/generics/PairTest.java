package kr.mjc.rachel.basics.generics;

/**
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">https://docs.oracle.com/javase/tutorial/java/generics/types.html</a>
 */

record Pair<T, U>(T first, U second) {
}

public class PairTest {
  public static void main(String[] args) {
    Pair<String, Integer> p1 = new Pair<>("Even", 8);
    Pair<String, String> p2 = new Pair<>("hello", "world");

    System.out.println(p1);
    System.out.println(p2);
  }
}
