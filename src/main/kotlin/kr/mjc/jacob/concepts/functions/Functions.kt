/*
 * https://kotlinlang.org/docs/functions.html
 */
package kr.mjc.jacob.concepts.functions

fun add(x: Int, y: Int): Int {
  return x + y
}

// Default arguments, Named arguments (기본값)
fun read(first: Int = 0, second: String = "", third: Boolean = false) {
  println("first=$first, second=$second, third=$third")
}

// Unit-returning (void). Unit은 생략 가능
fun printHello(name: String): Unit {
  println("Hello $name")
}

// Single-exression function
fun double(x: Int): Int = x * 2

fun main() {
  val result = add(3, 4)
  println(result)

  read()                    // first=0, second="", third=false
  read(1)                   // first=1, second="", third=false
  read(2, "Zendaya")        // first=2, second="Zendaya", third=false
  read(3, "Seydoux", true)  // first=3, second="Seydoux", third=true
  read(4, third = true)     // first=4, second="", third=true
  read(third = true, second = "Lea")  // first=0, second="Lea", third=true
}

