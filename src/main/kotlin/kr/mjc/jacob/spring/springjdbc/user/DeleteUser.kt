package kr.mjc.jacob.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.springjdbc.SpringJdbcConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.dao.EmptyResultDataAccessException
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringJdbcConfig::class.java)
  val userDao = context.getBean(UserDao::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Delete - username password ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val password = scanner.next()
  scanner.close()

  try {
    val user = userDao.getByUsername(username)
    if (user?.matchPassword(password) == true) {
      userDao.deleteById(user.id)
      log.info("삭제했습니다.")
    } else {
      log.debug("Wrong password.")
    }
  } catch (e: EmptyResultDataAccessException) {
    log.error("No user.")
  }
}