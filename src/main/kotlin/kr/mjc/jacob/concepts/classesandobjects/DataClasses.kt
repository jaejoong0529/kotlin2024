/**
 * https://kotlinlang.org/docs/data-classes.html
 */
package kr.mjc.jacob.concepts.classesandobjects

/*
 * 데이터 클래스는 데이터를 보유하는데 사용
 * 기본으로 다음 메서드들을 구현했다.
 * equals(), hashCode(), toString(), copy(), componentN()...
 */
data class User(val name: String, val age: Int)

class Person(val name: String, val age: Int)

fun main() {
  val u1 = User("Denis", 57)
  val u2 = User("Denis", 57)

  val p1 = Person("Villeneuve", 57)
  val p2 = Person("Villeneuve", 57)

  println(u1)         // toString() 구현
  println(p1)

  println(u1 == u2)   // hashCode()와 equals() 구현
  println(p1 == p2)

  val u3 = u1.copy()  // copy() 구현
  println(u3)
}