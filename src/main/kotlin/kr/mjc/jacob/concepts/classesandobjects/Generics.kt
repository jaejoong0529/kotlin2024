/*
 * https://kotlinlang.org/docs/generics.html
 */
package kr.mjc.jacob.concepts.classesandobjects

/*
 * type parameter. 타입이 파라미터로 들어간다.
 * class 클래스명<타입>(생성자) {...}
 * 보통 타입은 T,U,E,K,V 등의 알파벳 대문자 사용
 */
class Box<T>(t: T) {
  var value: T = t
}

/*
 * Generic functions. 함수명 앞에 타입 파라미터를 놓는다.
 */
fun <T> boxing(t: T): Box<T> {
  return Box<T>(t)
}

fun main() {
  val intBox = Box<Int>(1)
  val stringBox = Box<String>("Zendaya")

  val intValue: Int = intBox.value
  val stringValue: String = stringBox.value

  // Generic 함수를 호출할 때는 함수명 뒤에 타입을 넣는다.
  val booleanBox = boxing<Boolean>(false) // 인자로 Boolean 타입을 넣는다.
  val booleanValue: Boolean = booleanBox.value

  val doubleBox = boxing<Double>(3.14)    // 인자로 Double 타입을 넣는다.
  val doubleValue: Double = doubleBox.value
}