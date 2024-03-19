/*
 * https://kotlinlang.org/docs/basic-syntax.html#for-loop
 */
package kr.mjc.jacob.basicsyntax

fun main() {
  val items = listOf("apple", "banana", "kiwifruit")
  for (item in items) {
    println(item)
  }
}