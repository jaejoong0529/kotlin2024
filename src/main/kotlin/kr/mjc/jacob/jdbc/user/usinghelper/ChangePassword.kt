package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Change password - username oldPassword newPassword? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val oldPassword = scanner.next()
  val newPassword = scanner.next()
  scanner.close()

  val userDao = UserDaoImpl()
  val user: User? = userDao.getByUsername(username)
  if (user?.matchPassword(oldPassword) == true) {
    userDao.changePassword(user.id, newPassword.bcryptHashed)
    println("Password changed.")
  } else {
    println("Wrong username or password")
  }
}