/**
 * https://kotlinlang.org/docs/properties.html
 */
package kr.mjc.jacob.concepts.classesandobjects

/* properties는 private field와 getter/setter 로 되어 있음 */
class Address {
  var name: String = "Holmes, Sherlock"
  var street: String = "Baker"
  var city: String = "London"
  var state: String? = null
  var zip: String = "123456"
}

class Rectanglec(val width: Int, val height: Int) {
  val area: Int
    get() = this.width * this.height // 사용자 지정 getter
}

class Circle(var x: Int = 0, var y: Int = 0) {
  var radius: Int = 1   // property initializer
    set(value) {        // 사용자 지정 setter
      field = if (value >= 0) value else throw Exception("반지름이 0 미만")
    } // `field`를 backing field라 한다.

  override fun toString(): String {
    return "Circle(x=$x, y=$y, radius=$radius)"
  }
}

fun main() {
  val address = Address()
  println(address.name)

  val r = Rectanglec(3, 4)
  println("width=${r.width}, height=${r.height}, area=${r.area}")

  val c = Circle(5, 5)
  println(c)
  c.radius = -5
  println(c)
}
