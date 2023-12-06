package kr.mjc.jacob.basics.generics

fun main() {
  val b1 = Box(5)
  // println(b1.value + 2) -> error
  println((b1.value as Int) + 2) // type castring

  val b2 = Box("abc")
  // println(b2.value.length) -> error
  println((b2.value as String).length) // type casting

  val b3 = IntegerBox(5)
  println(b3.value + 2)

  val b4 = StringBox("abc")
  println(b4.value.length)

  val gb1 = GenericBox(5) // type inference
  println(gb1.value + 2)

  val gb2 = GenericBox("abc") // type inference
  println(gb2.value.length)
}