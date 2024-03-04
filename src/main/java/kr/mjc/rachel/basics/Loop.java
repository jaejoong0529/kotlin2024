package kr.mjc.rachel.basics;

import java.util.List;

public class Loop {
  public static void main(String[] args) {
    List<String> items = List.of("apple", "banana", "kiwifruit");
    for (String item : items) {
      System.out.println(item);
    }
  }
}
