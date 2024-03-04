/**
 * https://kotlinlang.org/docs/basic-syntax.html#variables
 */
package kr.mjc.jacob.basicsyntax

fun main() {
  val a: Int = 1 // final int a = 1. a는 read only
  val b = 2   // Type inference (타입 추론) : 2로 b가 Int 라는 것을 추론
  println("a = $a, b = $b") // String template

  var x = 5 // x는 재할당 가능
  x = 6
}