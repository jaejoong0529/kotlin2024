package kr.mjc.jacob.concepts.functions

class RunnerExample {
  // higher order function : 함수를 인자로 받거나 함수를 리턴하는 함수
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun repeat(n: Int, run: () -> Unit) {
    for (i in 0..<n) run()
  }

  // 인자가 없고 리턴이 없는 함수
  fun helloRachel() {
    println("Hello, Rachel!")
  }
}

fun main() {

  val exam = RunnerExample()

  // lamda expression
  // val 변수명 : (인자타입) -> 리턴타입 = { 구현 }
  val r1: () -> Unit = { println("Hello, World!") }

  exam.repeat(3, r1)
  exam.repeat(3) { println("Hello, Jacob!") }
  exam.repeat(3, exam::helloRachel)  // 함수 참조 : method reference
}
