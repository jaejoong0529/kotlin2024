package kr.mjc.jacob.basicsyntax

const val PI = 3.14

class Circle(val x: Int, val y: Int, val radius: Int)

fun main() {
  val c1 = Circle(0, 0, 1)
  val c2 = Circle(1, 1, 10)
  println(c1.x)
  println(c2.x)
  println(PI)
}