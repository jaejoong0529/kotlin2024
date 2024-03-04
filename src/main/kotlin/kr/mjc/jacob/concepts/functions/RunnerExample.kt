/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Runnable : 인자도 없고, 리턴도 없는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.jacob.concepts.functions

class RunnerExample {

  // 파라미터가 functional interface
  fun repeat(n: Int, runnable: Runnable) {
    for (i in 0..<n) runnable.run()
  }

  // higher order function : 함수를 인자로 받거나 함수를 리턴하는 함수
  // inline 함수 인스턴스를 만들지 않고 함수의 코드를 삽입한다.
  inline fun repeatHigherOrder(n: Int, run: () -> Unit) {
    for (i in 0..<n) run()
  }
}

fun main() {
  val exam = RunnerExample()

  // implements Runnable
  class Runner : Runnable {
    override fun run() {
      println("Hello, World!")
    }
  }

  val r1 = Runner()
  exam.repeat(3, r1)

  // anonymous implementation
  val r2 = Runnable {
    println("Hello, Jacob!")
  }
  exam.repeat(3, r2)

  // lamda expression : functional interface를 lamda로 바꿀수 있다.
  // val 변수명 : (인자타입) -> 리턴타입 = { 구현 }
  val r3: () -> Unit = { println("Hello, Rachel!") }

  exam.repeat(3, r3)
  exam.repeat(3) { println("Hello, David!") }
  exam.repeat(3, ::helloJacob)  // 함수 참조 : method reference
  exam.repeat(3, helloRachel)   // lambda expression 변수명

  // higher order function 호출
  exam.repeatHigherOrder(3, r3)
  exam.repeatHigherOrder(3) { println("Hello, Sarah!") }
  exam.repeatHigherOrder(3, ::helloJacob)
  exam.repeatHigherOrder(3, helloRachel)
}

// 인자가 없고 리턴이 없는 함수
fun helloJacob() {
  println("Hello, Jacob")
}

// 함수를 lambda expression으로 표현
val helloRachel: () -> Unit = { println("Hello, Rachel") }
