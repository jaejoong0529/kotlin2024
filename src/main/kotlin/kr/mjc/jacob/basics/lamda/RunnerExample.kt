/*
 * @FunctionalInterface : abstract 메서드가 1개 있는 인터페이스
 * Runnable : 인자도 없고, 리턴도 없는 함수를 갖는 @FunctionalInterface
 */
package kr.mjc.jacob.basics.lamda

class RunnerExample {

  fun repeat(n: Int, runnable: Runnable) {
    for (i in 0..<n) runnable.run()
  }

  // higher order function
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
  val r3: () -> Unit = { println("Hello, Rachel!") }

  exam.repeat(3, r3)
  exam.repeat(3) { println("Hello, David!") }
  exam.repeat(3, ::helloJacob)
  exam.repeat(3, helloRachel)

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
