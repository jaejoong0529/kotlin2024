package kr.mjc.jacob.thymeleaf

import java.io.FileWriter

fun main() {
  hello("World")
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