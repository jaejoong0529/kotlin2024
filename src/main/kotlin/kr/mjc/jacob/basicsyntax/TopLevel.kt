/*
 * https://kotlinlang.org/docs/basic-syntax.html#variables
 */
package kr.mjc.jacob.basicsyntax

// 클래스 밖에 선언된 변수나 함수는 static
val E = 2.72
var x = 0

fun incrementX() {
  x += 1
}

fun main() {
  println("x = $x; PI = $E")
  incrementX()
  println("x = $x")
}