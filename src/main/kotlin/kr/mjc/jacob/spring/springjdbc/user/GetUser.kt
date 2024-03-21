package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.SpringJdbcConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.dao.EmptyResultDataAccessException
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringJdbcConfig::class.java)
  val userDao = context.getBean(UserDao::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }

  try {
    val user = userDao.getById(id)
    log.info(user.toString())
  } catch (e: EmptyResultDataAccessException) {
    log.error("No user.")
  }
}
