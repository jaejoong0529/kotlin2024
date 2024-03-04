/**
 * https://kotlinlang.org/docs/collections-overview.html#map
 */
package kr.mjc.jacob.concepts.collections

/**
 * Map : key=value 쌍의 목록. key 목록은 Set이다.
 */
fun main() {
  // 기본으로 read-only
  val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
  println(numbersMap)
  println("All keys: ${numbersMap.keys}")
  println("All values: ${numbersMap.values}")
  if ("key2" in numbersMap) println("key2 = ${numbersMap["key2"]}")

  // 내용물 변경이 가능한 map
  val numbersMap2 = mutableMapOf("one" to 1, "two" to 2) // {one=1, two=2}
  numbersMap2.put("three", 3) // {one=1, two=2, three=3}
  numbersMap2["four"] = 4     // {one=1, two=2, three=3, four=4}
  numbersMap2["one"] = 11     // {one=11, two=2, three=3, four=4}
  println(numbersMap2)
}