package kr.mjc.jacob.basics.jdbc.user.dao

import java.util.*

fun main() {
  print("Get - userId ? ")
  val userId = Scanner(System.`in`).use { it.nextInt() }

  val user = UserDao.getUser(userId)
  println(user)
}
