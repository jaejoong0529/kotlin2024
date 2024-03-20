package kr.mjc.jacob.jdbc.user.usinghelper

import org.mindrot.jbcrypt.BCrypt
import java.sql.SQLException
import java.util.*

fun main() {
  print("Login - username password ? ")
  var username: String
  var password: String
  Scanner(System.`in`).use {
    username = it.next()
    password = it.next()
  }

  try {
    val user = UserRepositoryImpl().findByUsername(username)
    val result: Boolean = BCrypt.checkpw(password, user.password)
    if (result) println(user)
    else println("Wrong password")
  } catch (e: SQLException) {
    println(e.message)
  }
}
