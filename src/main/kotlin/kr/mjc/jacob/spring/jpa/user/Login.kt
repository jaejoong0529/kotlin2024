package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Login - username(email) password ? ")
  val (username, password) = Scanner(System.`in`).use {
    arrayOf(it.next(), it.next())
  }

  val user = userService.login(username, password) ?: return
  log.info(user.toString())
}
