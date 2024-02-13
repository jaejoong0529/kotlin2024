package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.JdbcHelper
import java.util.*

fun main() {
  print("Get - userId ? ")
  val userId = Scanner(System.`in`).use { it.nextInt() }

  try {
    val user = UserDaoImpl().getUser(userId)
    println(user)
  } catch (e: JdbcHelper.NoResultException) {
    println("No user")
  }
}
