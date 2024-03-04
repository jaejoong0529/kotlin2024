package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.JdbcHelper
import org.mindrot.jbcrypt.BCrypt
import java.util.*

fun main() {
  print("Login - username oldPassword newPassword? ")
  var username: String
  var oldPassword: String
  var newPassword: String
  Scanner(System.`in`).use {
    username = it.next()
    oldPassword = it.next()
    newPassword = it.next()
  }

  val userDao = UserRepositoryImpl()
  try {
    val user = userDao.findByUsername(username)
    val result: Boolean = BCrypt.checkpw(oldPassword, user.password)
    if (result) {
      userDao.changePassword(user.id!!,
          BCrypt.hashpw(newPassword, BCrypt.gensalt()))
      println("Password changed!")
    } else println("Wrong password")
  } catch (e: JdbcHelper.NoResultException) {
    println("No user")
  }
}