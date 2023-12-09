package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.user.User
import java.util.*

fun main() {
  print("Get - email password name ? ")
  val user = User().apply {
    Scanner(System.`in`).use {
      email = it.next()
      password = it.next()
      name = it.next()
    }
  }

  UserDaoImpl.addUser(user)
  println(user)
}
