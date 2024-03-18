/*
 * https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-nullable-types
 */
package kr.mjc.jacob.basicsyntax

/**
 * Safe calls
 */
fun main() {
  var a: String = "abc" // a는 null이 될 수 없다.
  // a = null // compilation error

  var b: String? = "abc" // b는 null이 될 수 있다. null이 가능한 변수에 ? 붙임
  b = null // ok
  println(b)

  println("a.length = ${a.length}")
  println("b.length = ${b?.length}") // if (b!=null) b.length else null
}