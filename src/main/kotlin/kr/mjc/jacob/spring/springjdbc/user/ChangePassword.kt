package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Change password - username oldPassword newPassword? ")
  val (username, oldPassword, newPassword) = Scanner(System.`in`).use {
    arrayOf(it.next(), it.next(), it.next())
  }

  val user = userService.login(username, oldPassword) ?: return
  userDao.changePassword(user.id, newPassword.bcryptHashed)
  log.info("Password changed.")
}