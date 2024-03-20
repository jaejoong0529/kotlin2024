package kr.mjc.jacob.jdbc.user.usinghelper

import org.mindrot.jbcrypt.BCrypt
import java.sql.SQLException
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
    if (result) { // 비밀번호가 매치할 경우
      userDao.changePassword(user.id,
          BCrypt.hashpw(newPassword, BCrypt.gensalt()))
      println("Password changed.")
    } else {  // 비밀번호가 매치하지 않을 경우
      println("Wrong password")
    }
  } catch (e: SQLException) {
    println(e.message)
  }
}