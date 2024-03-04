/**
 * https://kotlinlang.org/docs/arrays.html#create-arrays
 */
package kr.mjc.jacob.concepts.types

fun main() {
  val simpleArray: Array<Int> = arrayOf(1, 2, 3)
  println(simpleArray.joinToString(","))

  // 3칸짜리 배열, 모두 null로 초기화
  val nullArray: Array<Int?> = arrayOfNulls(3)
  println(nullArray.joinToString(","))

  // 빈 배열 (0칸 짜리 배열)
  val exampleArray = emptyArray<String>()
  println(exampleArray.size)

  // 타입을 왼쪽이나 오른쪽 아무곳에나 선언해도 된다.
  val exampleArray2: Array<String> = emptyArray()

  // 3칸짜리 정수 배열. 0으로 초기화
  val initArray = Array<Int>(3) { 0 }
  println(initArray.joinToString())
}