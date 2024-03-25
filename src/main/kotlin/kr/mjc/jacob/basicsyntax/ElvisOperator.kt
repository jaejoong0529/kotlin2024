/*
 * https://kotlinlang.org/docs/null-safety.html#elvis-operator
 */
package kr.mjc.jacob.basicsyntax

fun main() {
  val b: String = "abc"
  val l: Int = b.length // if (b != null) b.length else -1
  println(l)
}
