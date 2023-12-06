package kr.mjc.jacob.basics.collections

/**
 * p.401 예제 7-1 수정. List 테스트<br>
 * Vector는 동기화 되어 있다(thread-safe).
 * 동기화가 필요없는 목록에는 ArrayList를 사용한다.
 */
fun main() {
  val list = listOf(5, 4, -1)
  println(list)

  for (item in list) println(item)

  // lamda
  list.forEach { item -> println(item) }

  // method reference
  list.forEach(System.out::println)
}