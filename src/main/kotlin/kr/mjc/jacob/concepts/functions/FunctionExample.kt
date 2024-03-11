package kr.mjc.jacob.concepts.functions

class FunctionExample {
  // higher order function
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun <T, R> transform(list: List<T>, apply: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (e in list) result.add(apply(e))
    return result
  }

  fun tenTimes(n: Int): Int = n * 10
}

fun main() {
  val exam = FunctionExample()
  val list1 = listOf(1, 2, 3)

  // lamda expression
  val f1: (Int) -> Int = { n -> n * 10 }
  val list2 = exam.transform(list1, f1)
  val list3 = exam.transform(list1) { n -> n * 10 }
  val list4 = exam.transform(list1, exam::tenTimes)

  println(list2)
  println(list3)
  println(list4)
}
