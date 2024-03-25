package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Login - username password ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val password = scanner.next()
  scanner.close()

  val user: User? = UserDaoImpl().getByUsername(username)
  if (user?.matchPassword(password) == true) println(user)
  else println("Wrong username or password.")
}
