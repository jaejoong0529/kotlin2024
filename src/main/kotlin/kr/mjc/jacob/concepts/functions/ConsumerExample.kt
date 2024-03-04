/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Consumer<T> : 인자가 1개 있고, 리턴이 없는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.jacob.concepts.functions

import java.util.function.Consumer

class ConsumerExample {

  fun <T> repeat(list: List<T>, consumer: Consumer<T>) {
    for (e in list) consumer.accept(e)
  }

  // higher order function
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun <T> repeatHigherOrder(list: List<T>, accept: (T) -> Unit) {
    for (e in list) accept(e)
  }
}

fun main() {
  val exam = ConsumerExample()
  val list1 = listOf("apple", "tomato", "lemon")

  // implements Consumer
  class ConsumerImpl<T> : Consumer<T> {
    override fun accept(t: T) {
      println(t)
    }
  }

  val c1 = ConsumerImpl<String>()
  exam.repeat(list1, c1)

  // anonymous implementation. Consumer의 구현체 인스턴스를 만든다.
  val c2 = Consumer<String> { e -> println(e) }
  exam.repeat(list1, c2)

  // lamda expression : functional interface를 lamda로 바꿀수 있다.
  // val 변수명 : (인자타입) -> 리턴타입 = { 인자 -> 구현 }
  val c3: (String) -> Unit = { e -> println(e) }
  exam.repeat(list1, c3)
  exam.repeat(list1) { e -> println(e) }
  exam.repeat(list1, ::processString)
  exam.repeat(list1, runString)

  // higher order function 호출
  exam.repeatHigherOrder(list1, c3)
  exam.repeatHigherOrder(list1) { e -> println("[$e]") }
  exam.repeatHigherOrder(list1, ::processString)
  exam.repeatHigherOrder(list1, runString)
}

fun processString(str: String) {
  println("$str, length=${str.length}")
}

val runString: (String) -> Unit = { str ->
  println("$str, length=${str.length}")
}