/**
 * https://kotlinlang.org/docs/basic-syntax.html#when-expression
 */
package kr.mjc.jacob.basicsyntax

fun describe(obj: Any): String = when (obj) {
  1 -> "One"
  "Hello" -> "Greeting"
  is Long -> "Long"
  !is String -> "Not a string"
  else -> "Unknown"
}

fun main() {
  println(describe(1))
  println(describe("Hello"))
  println(describe(1000L))
  println(describe(2))
  println(describe("other"))
}