/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Consumer<T> : 인자가 1개 있고, 리턴이 없는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.rachel.concepts.functions;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

  public <T> void repeat(List<T> list, Consumer<T> consumer) {
    for (T e : list)
      consumer.accept(e);
  }

  public static void main(String[] args) {
    ConsumerExample exam = new ConsumerExample();
    List<String> list1 = List.of("apple", "tomato", "lemon");

    Consumer<String> c1 = new Consumer<>() { // anonymous class
      @Override
      public void accept(String str) {
        System.out.println(str);
      }
    };

    exam.repeat(list1, c1);
  }
}
