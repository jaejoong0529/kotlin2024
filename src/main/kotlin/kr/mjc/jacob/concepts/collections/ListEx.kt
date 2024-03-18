/*
 * https://kotlinlang.org/docs/collections-overview.html#list
 */
package kr.mjc.jacob.concepts.collections

/**
 * List : 순서가 있는 목록
 */
fun main() {
  // 기본으로 read-only
  val numbers1 = listOf("one", "two", "three", "four")
  println(numbers1)
  println("Number of elements: ${numbers1.size}")
  println("Fourth element: ${numbers1[3]}")

  // 내용물 변경이 가능한 list
  val numbers2 = mutableListOf(1, 2, 3, 4) // [1,2,3,4]
  numbers2.add(5)       // [1,2,3,4,5]
  numbers2.removeAt(1)  // [1,3,4,5]
  numbers2[0] = 0       // [0,3,4,5]
  println(numbers2)
}