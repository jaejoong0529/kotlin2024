package kr.mjc.jacob.concepts.functions

class FunctionExample {
  // higher order function : 함수를 인자로 받거나 함수를 리턴하는 함수
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
  val list4 = exam.transform(list1, exam::tenTimes) // method reference

  println("list2 = $list2")
  println("list3 = $list3")
  println("list4 = $list4")

  // collection.map 은 transform 함수
  val list5 = list1.map { n -> n * 10 }
  val list6 = list1.map(exam::tenTimes)
  println("list5 = $list5")
  println("list6 = $list6")
}
