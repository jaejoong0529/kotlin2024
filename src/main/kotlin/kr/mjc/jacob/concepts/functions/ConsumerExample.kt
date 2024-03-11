package kr.mjc.jacob.concepts.functions

class ConsumerExample {
  // higher order function
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun <T> repeat(list: List<T>, accept: (T) -> Unit) {
    for (e in list) accept(e)
  }

  fun printString(str: String) {
    println("$str, length=${str.length}")
  }
}

fun main() {
  val exam = ConsumerExample()
  val list1 = listOf("apple", "tomato", "lemon")

  // lamda expression
  // val 변수명 : (인자타입) -> 리턴타입 = { 인자 -> 구현 }
  val c1: (String) -> Unit = { e -> println(e) }

  exam.repeat(list1, c1)
  exam.repeat(list1) { e -> println(e) }
  exam.repeat(list1, exam::printString)
}
