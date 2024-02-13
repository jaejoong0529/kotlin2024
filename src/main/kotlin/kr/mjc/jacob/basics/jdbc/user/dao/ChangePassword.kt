package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.JdbcHelper
import org.mindrot.jbcrypt.BCrypt
import java.util.*

fun main() {
  print("Login - email oldPassword newPassword? ")
  var email: String
  var oldPassword: String
  var newPassword: String
  Scanner(System.`in`).use {
    email = it.next()
    oldPassword = it.next()
    newPassword = it.next()
  }

  val userDao = UserDaoImpl()
  try {
    val user = userDao.getUserWithEmail(email)
    val result: Boolean = BCrypt.checkpw(oldPassword, user.password)
    if (result) {
      userDao.changePassword(user.userId!!,
          BCrypt.hashpw(newPassword, BCrypt.gensalt()))
      println("Password changed!")
    } else println("Wrong password")
  } catch (e: JdbcHelper.NoResultException) {
    println("No user")
  }
}