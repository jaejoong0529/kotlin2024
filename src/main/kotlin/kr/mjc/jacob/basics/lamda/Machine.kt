package kr.mjc.jacob.basics.lamda

/**
 * 실행기
 *
 * @author Jacob
 */
class Machine {

  /**
   * 인자가 없는 메서드를 두번 실행
   */
  fun doTwice(run: () -> Unit) {
    run()
    run()
  }

  /**
   * 인자가 1개 있는 메서드를 두번 실행
   */
  fun doTwice(name: String, accept: (String) -> Unit) {
    accept(name)
    accept(name)
  }
}

fun main() {
  val machine = Machine()

  machine.doTwice { println("Hello Jacob") }
  machine.doTwice { sayHello("Rachel") }
  machine.doTwice("David") { name -> sayHello(name) }
  machine.doTwice("John", ::sayHello)
}

fun sayHello(name: String) {
  println("Hello $name")
}