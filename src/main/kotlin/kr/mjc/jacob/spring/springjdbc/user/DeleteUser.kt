package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Delete user - username(email) password ? ")
  val (username, password) = Scanner(System.`in`).use {
    arrayOf(it.next(), it.next())
  }

  val user = userService.login(username, password) ?: return
  try {
    userDao.deleteById(user.id)
    log.info("삭제했습니다.")
  } catch (e: DataIntegrityViolationException) {
    log.error("post에 올린 글이 있어서 삭제할 수 없습니다.")
  }
}