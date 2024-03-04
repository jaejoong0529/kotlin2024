package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.JdbcHelper
import java.util.*

fun main() {
  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }

  try {
    val user = UserRepositoryImpl().findById(id)
    println(user)
  } catch (e: JdbcHelper.NoResultException) {
    println("No user")
  }
}
