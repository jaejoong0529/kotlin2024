package kr.mjc.jacob.basics.collections

/**
 * p.418 예제 7-7. HashMapStudentEx 수정
 */
fun main() {
  val s1 = Student(1, "Jacob")
  val s2 = Student(2, "Rachel")
  val s3 = Student(3, "David")

  val map1 = mapOf(1 to s1, 2 to s2, 3 to s3)
  println(map1)
  println(map1[2])

  // entrySet
  for (e in map1) println("key:${e.key}, value:${e.value}")

  // key, value
  for ((k, v) in map1) println("key:$k, value:$v")

  // lamda
  map1.forEach { (k, v) -> println("key:$k, value:$v") }
}