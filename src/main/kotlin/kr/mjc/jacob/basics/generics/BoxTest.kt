package kr.mjc.jacob.basics.generics

/**
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/generics/types.html">https://docs.oracle.com/javase/tutorial/java/generics/types.html</a>
 */
data class Box(val value: Any)

data class IntegerBox(val value: Int)

data class StringBox(val value: String)

data class GenericBox<T>(val value: T)

fun main() {
  val b1 = Box(5)
  // println(b1.value + 2) -> error
  println((b1.value as Int) + 2) // type casting

  val b2 = Box("abc")
  // println(b2.value.length) -> error
  println((b2.value as String).length) // type casting

  val b3 = IntegerBox(5)
  println(b3.value + 2)

  val b4 = StringBox("abc")
  println(b4.value.length)

  // Generic
  val b5 = GenericBox(5) // type inference
  println(b5.value + 2)

  val b6 = GenericBox("abc") // type inference
  println(b6.value.length)
}