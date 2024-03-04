/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Function<T,R> : 인자가 1개 있고, 리턴값이 있는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.jacob.concepts.functions

import java.util.function.Function

class FunctionExample {

  fun <T, R> repeat(list: List<T>, function: Function<T, R>): List<R> {
    val result = mutableListOf<R>()
    for (e in list) result.add(function.apply(e))
    return result
  }

  // higher order function
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun <T, R> repeatHigherOrder(list: List<T>, apply: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (e in list) result.add(apply(e))
    return result
  }
}

fun main() {
  val exam = FunctionExample()
  val list1 = listOf(1, 2, 3)

  val f1 = Function<Int, Int> { n -> n * 10 }
  exam.repeat(list1, f1)

  // lamda expression : functional interface를 lamda로 바꿀수 있다.
  val f2: (Int) -> Int = { n -> n * 10 }
  exam.repeat(list1, f2)
  exam.repeat(list1) { n -> n * 10 }
  exam.repeat(list1, ::comeString)
  exam.repeat(list1, goString)

  // higher order function 호출
  exam.repeatHigherOrder(list1, f2)
  exam.repeatHigherOrder(list1) { n -> n * 10 }
  exam.repeatHigherOrder(list1, ::comeString)
  exam.repeatHigherOrder(list1, goString)
}

fun comeString(n: Int): Int = n * 10

val goString = { n: Int -> n * 10 }