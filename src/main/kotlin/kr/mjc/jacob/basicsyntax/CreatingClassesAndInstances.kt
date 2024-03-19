/*
 * https://kotlinlang.org/docs/basic-syntax.html#creating-classes-and-instances
 */
package kr.mjc.jacob.basicsyntax

open class Shape

class Rectangle(val height: Double, val length: Double) : Shape() {
  val perimeter = (height + length) * 2 // property initializer
}

fun main() {
  val rectangle = Rectangle(5.0, 2.0) // new를 사용하지 않는다.
  println("The perimeter is ${rectangle.perimeter}")
}
