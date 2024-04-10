package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Delete - username(email) password ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val password = scanner.next()
  scanner.close()

  val user = userService.login(username, password) ?: return
  userDao.deleteById(user.id)
  log.info("삭제했습니다.")
}