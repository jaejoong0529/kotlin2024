package kr.mjc.rachel.basics.generics;

/**
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">https://docs.oracle.com/javase/tutorial/java/generics/types.html</a>
 */
record Box(Object value) {
}

record IntegerBox(int value) {
}

record StringBox(String value) {
}

record GenericBox<T>(T value) {
}

public class BoxTest {
  public static void main(String[] args) {
    Box b1 = new Box(5);
    // int i = b1.value(); -> error
    int i1 = (int) b1.value(); // type casting

    Box b2 = new Box("abc");
    // String s = b2.value(); -> error
    String s1 = (String) b2.value(); // type casting

    IntegerBox b3 = new IntegerBox(5);
    int i2 = b3.value();

    StringBox b4 = new StringBox("abc");
    String s2 = b4.value();

    // Generic
    GenericBox<Integer> b5 = new GenericBox<>(5);
    int i3 = b5.value();

    GenericBox<String> b6 = new GenericBox<>("abc");
    String s3 = b6.value();
  }
}
