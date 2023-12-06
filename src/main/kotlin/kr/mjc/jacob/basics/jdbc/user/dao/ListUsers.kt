package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.user.Limit
import java.util.*

fun main() {
  print("List - count page ? ")
  val limit = Limit().apply {
    Scanner(System.`in`).use {
      count = it.nextInt()
      page = it.nextInt()
    }
  }

  val userList = UserDao.listUsers(limit)
  println(userList)
}