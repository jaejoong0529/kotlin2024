/**
 * https://kotlinlang.org/docs/classes.html#constructors
 */
package kr.mjc.jacob.concepts.classesandobjects

class Persona

/* val이나 var가 붙으면 property.
 * val은 getter만 var는 getter와 setter */
class Personb(val firstName: String)

/* property initializer와 initializer block
   property initializer와 initializer block은 primary constructor의 일부 */
class InitOrderDemo(name: String) { // name은 property가 아니다.
  val firstProperty = "First property: $name" // property initializer

  init {  // initializer block
    println(firstProperty)
  }
}

class Customer(name: String) {  // name은 property가 아니다.
  val customerKey = name.uppercase()
}

// constructor에서 default 값을 줄 수 있다.
class Personc(val firstName: String, val lastName: String, var age: Int = 1)

fun main() {
  val pa = Persona()

  val pb = Personb("Jacob")
  println(pb.firstName)

  val order = InitOrderDemo("hello")

  val c = Customer("Rachel")
  println(c.customerKey)

  var pc = Personc("Timothee", "Chalamet", 29)
  pc = Personc("Timothee", "Chalamet")  // age = 1 : 기본값
  pc.age = 29
  pc = Personc(lastName = "Chalamet", firstName = "Timothee")  // named args
}
