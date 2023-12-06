package kr.mjc.jacob.basics.collections

/**
 * Set 테스트
 */
fun main() {
  val set1 = mutableSetOf("Melon", "Apple", "Strawberry")
  set1.add("Apple") // 중복 오브젝트를 넣음

  println(set1)

  // enhanced for
  for (e in set1) println(e)

  // lamda
  set1.forEach { e -> println(e) }

  // method reference
  set1.forEach(System.out::println)
}