/*
 * https://kotlinlang.org/docs/scope-functions.html
 */
package kr.mjc.jacob.stdlibs

import java.io.File

data class Person(var name: String = "", var age: Int = 0)

fun main() {
  // let : lambda의 결과를 리턴. 주로 다른 함수에 인자로 넣어서 실행할 때 사용
  val adam = Person("Adam", 20)
  println("name = ${adam.name}")
  println("age = ${adam.age}")

  Person("Eve", 17).let {
    println("name = ${it.name}")
    println("age = ${it.age}")
  }

  Person("Peter", 21).let { person ->
    println("name = ${person.name}")
    println("age = ${person.age}")
  }

  // apply : context object를 리턴. 주로 오브젝트를 구성할 때 사용
  val andre = Person()
  andre.name = "Andre"
  andre.age = 22

  val jacob = Person().apply {
    this.name = "Jacob"
    this.age = 23
  }
  println(jacob)

  // use : AutoCloseable 객체를 자동 close()
  File("README.md").bufferedReader().use { reader ->
    reader.forEachLine(::println)
  }
}
