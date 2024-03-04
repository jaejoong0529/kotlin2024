package kr.mjc.jacob.concepts.functions

fun main() {
  val stringPlus: (String, String) -> String = { a, b -> a + b }
  val intPlus: Int.(Int) -> Int = Int::plus

  println(stringPlus("<-", "->"))
  println(stringPlus.invoke("<-", "->"))
  println(intPlus(1, 2))
  println(intPlus.invoke(1, 2))
  println(1.intPlus(2))
}