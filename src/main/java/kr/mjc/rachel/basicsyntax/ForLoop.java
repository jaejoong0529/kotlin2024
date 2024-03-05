package kr.mjc.rachel.basicsyntax;

import java.util.List;

public class ForLoop {
  public static void main(String[] args) {
    List<String> items = List.of("apple", "banana", "kiwifruit");
    for (String item : items) {
      System.out.println(item);
    }
  }
}
