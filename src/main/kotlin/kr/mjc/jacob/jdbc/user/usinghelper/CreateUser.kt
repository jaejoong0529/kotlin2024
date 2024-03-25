package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Create - username(username) password first_name ? ")
  val user = Scanner(System.`in`).use {
    User(username = it.next(), password = it.next().bcryptHashed,
        firstName = it.next())
  }

  val userDao = UserDaoImpl()
  if (userDao.getByUsername(user.username) == null) { // username 없을 경우
    val userCreated = userDao.create(user)
    println(userCreated)
  } else {
    println("username이 존재합니다.")
  }
}
