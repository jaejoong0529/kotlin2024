/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Function<T,R> : 인자가 1개 있고, 리턴값이 있는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.rachel.concepts.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
  public <T, R> List<R> transform(List<T> list, Function<T, R> func) {
    List<R> result = new ArrayList<>();
    for (T e : list) result.add(func.apply(e));
    return result;
  }

  public static void main(String[] args) {
    FunctionExample exam = new FunctionExample();
    List<Integer> list1 = List.of(1, 2, 3);

    Function<Integer, Integer> func = new Function<>() {
      @Override
      public Integer apply(Integer n) {
        return n * 10;
      }
    };

    List<Integer> list2 = exam.transform(list1, func);
    System.out.println(list2);
  }
}
