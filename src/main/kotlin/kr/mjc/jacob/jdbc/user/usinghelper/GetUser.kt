package kr.mjc.jacob.jdbc.user.usinghelper

import java.sql.SQLException
import java.util.*

fun main() {
  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }

  try {
    val user = UserDaoImpl().getById(id)
    println(user)
  } catch (e: SQLException) {
    println(e.message)
  }
}
