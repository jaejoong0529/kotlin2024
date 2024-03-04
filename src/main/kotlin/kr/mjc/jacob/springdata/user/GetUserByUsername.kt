package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.AppConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.dao.DataAccessException
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger(object {}.javaClass.enclosingClass)

  print("Get - username ? ")
  val username = Scanner(System.`in`).use { it.next() }
  try {
    val user = userRepository.findByUsername(username)
    log.debug(user.toString())
  } catch (e: DataAccessException) {
    log.error("회원 없음: username=$username")
  }
}
