package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Get - username(username) password first_name ? ")
  val scanner = Scanner(System.`in`)
  val user = User(username = scanner.next(), password = scanner.next(),
      firstName = scanner.next()).hashPassword()
  scanner.close()

  val userCreated = UserRepositoryImpl().save(user)
  println(userCreated)
}
