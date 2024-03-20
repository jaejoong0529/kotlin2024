package kr.mjc.jacob.springjdbc.user

import kr.mjc.jacob.jdbc.user.UserRepository
import kr.mjc.jacob.springjdbc.AppConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.dao.DataAccessException
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger(object {}.javaClass)

  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }
  try {
    val user = userRepository.findById(id)
    log.debug(user.toString())
  } catch (e: DataAccessException) {
    log.error("회원 없음: id=$id")
  }
}
