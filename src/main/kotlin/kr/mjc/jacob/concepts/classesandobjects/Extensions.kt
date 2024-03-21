/*
 * https://kotlinlang.org/docs/extensions.html
 */
package kr.mjc.jacob.concepts.classesandobjects

/**
 * Extension function
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
  val tmp = this[index1]
  this[index1] = this[index2]
  this[index2] = tmp
}

/**
 * Extension property
 */
val <T> List<T>.lastElement: T get() = this[size - 1]

fun main() {
  val list = mutableListOf(10, 20, 30)
  list.swap(1, 2)
  println(list)

  println(list.lastElement)
}