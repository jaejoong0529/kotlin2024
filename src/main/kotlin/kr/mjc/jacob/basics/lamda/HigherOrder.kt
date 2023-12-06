package kr.mjc.jacob.basics.lamda

class HigherOrder {
  fun calc(a: Double, b: Double, func: (Double, Double) -> Double) = func(a, b)
}

fun main() {
  println(HigherOrder().calc(1.0, 2.0) { a, b -> a / b })
}