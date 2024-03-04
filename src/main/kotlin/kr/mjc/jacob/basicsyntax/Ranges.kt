/**
 * https://kotlinlang.org/docs/basic-syntax.html#ranges
 */
package kr.mjc.jacob.basicsyntax

fun main() {
  for (x in 0..10) {  // 0 ~ 10
    print(x)
  }
  println()

  for (x in 0..<10) { // 0 ~ 9
    print(x)
  }
  println()

  for (x in 1..10 step 2) { // 1 3 5 7 9
    print(x)
  }
  println()

  for (x in 9 downTo 0 step 3) { // 9 6 3
    print(x)
  }
}