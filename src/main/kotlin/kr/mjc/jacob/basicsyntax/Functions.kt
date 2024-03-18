/*
 * https://kotlinlang.org/docs/basic-syntax.html#functions
 */
package kr.mjc.jacob.basicsyntax

fun sum(a: Int, b: Int): Int {
  return a + b
}

// 함수가 구문 1개일 때 =로 쓸 수 있다.
fun sum2(a: Int, b: Int) = a + b // type inference. Int 생략 가능

// 리턴을 안할 때 Unit. 생략 가능
fun printSum(a: Int, b: Int): Unit {
  println("sum of $a and $b is ${a + b}")
}

// 함수가 구문 1개일 때 =로 쓸 수 있다.
fun printSum2(a: Int, b: Int) = println("sum of $a and $b is ${a + b}")

fun main() {
  println("sum of 3 and 5 is ${sum2(3, 5)}")
  printSum2(10, 20)
}
