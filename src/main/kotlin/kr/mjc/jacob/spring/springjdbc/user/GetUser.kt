package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Get user - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }

  try {
    val user = userDao.getById(id)
    log.info(user.toString())
  } catch (e: EmptyResultDataAccessException) {
    log.error("No user.")
  }
}
