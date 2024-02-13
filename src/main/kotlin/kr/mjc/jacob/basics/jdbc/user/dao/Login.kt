package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.JdbcHelper
import org.mindrot.jbcrypt.BCrypt
import java.util.*

fun main() {
  print("Login - email password ? ")
  var email: String
  var password: String
  Scanner(System.`in`).use {
    email = it.next()
    password = it.next()
  }

  try {
    val user = UserDaoImpl().getUserWithEmail(email)
    val result: Boolean = BCrypt.checkpw(password, user.password)
    if (result) println(user)
    else println("Wrong password")
  } catch (e: JdbcHelper.NoResultException) {
    println("No user")
  }
}
