package kr.mjc.jacob.thymeleaf

import java.io.FileWriter
import java.util.*

fun main() {
  print("name ? ")
  val name = Scanner(System.`in`).use { it.next() }
  hello(name)
}

fun hello(name: String) {
  FileWriter("responses/hello_world.html").use { writer ->
    writer.write("""
      <!DOCTYPE html>
      <html>
      <body>
      <h1>Hello $name</h1>
      </body>
      </html>""".trimIndent())
  }
}