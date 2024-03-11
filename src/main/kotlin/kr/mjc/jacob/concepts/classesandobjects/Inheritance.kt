/**
 * https://kotlinlang.org/docs/inheritance.html
 */
package kr.mjc.jacob.concepts.classesandobjects

class Example // Kotlin에는 최상위 클래스 Any가 있다. 암묵적으로 Any에서 상속

open class Base(val p: Int) // Kotlin 클래스는 기본적으로 final. 상속을 위해 open

open class Derived(p: Int) : Base(p)

/* Overriding methods */
open class Shapea {
  open fun draw() {}      // 하위 클래스에서 메서드를 재정의 하려면 open
  fun fill() {}
}

class Rectanglea : Shapea() {
  override fun draw() {}  // 재정의 하는 메서드는 override
}

/* Overriding properties */
open class Shapeb {
  open val vertexCount: Int = 0
}

class Rectangleb : Shapeb() {
  override val vertexCount = 4
}

/* 파생 클래스 초기화 순서. 부모클래스부터 초기화 됨 */
open class Baseb(val name: String) {
  init {  // initializer block 은 primary constructor의 일부
    println("Initializing a base class")
  }

  // property initializer 는 primary constructor의 일부
  open val size: Int = name.length
}

class Derivedb(name: String, val lastName: String) : Baseb(name) {
  init {  // initializer block
    println("Initializing a derived class")
  }

  override val size: Int = super.size + lastName.length // property initializer
}

fun main() {
  val d = Derived(5)
  println(d.p)

  val db = Derivedb("Timotheee", "Chalamet")
  println(db.size)
}
