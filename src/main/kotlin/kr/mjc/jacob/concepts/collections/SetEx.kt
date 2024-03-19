/*
 * https://kotlinlang.org/docs/collections-overview.html#set
 */
package kr.mjc.jacob.concepts.collections

/**
 * Set : 중복이 없는 순서가 중요하지 않은 목록
 */
fun main() {
  // 기본으로 read-only
  val numbers = setOf(1, 2, 3, 4)
  println(numbers)

  val numbersBackwards = setOf(4, 3, 2, 1)
  println(numbersBackwards)

  // set은 크기가 같고 내용물이 같으면 같은 set.
  println(numbers == numbersBackwards) // == 내용물 비교 (깊은 비교)

  println(numbers === numbersBackwards) // == 레퍼런스 비교 (얕은 비교)

  // 내용물 변경이 가능한 set
  val numbers2 = mutableSetOf(1, 2, 3)
  numbers2.add(3)
  numbers2.add(4)
  println(numbers2)
}