package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.AppConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger(object {}.javaClass.enclosingClass)

  print("Get - username(email) password first_name ? ")
  val scanner = Scanner(System.`in`)
  val user = User(username = scanner.next(), password = scanner.next(),
      firstName = scanner.next()).hashPassword()
  scanner.close()

  try {
    val userCreated = userRepository.save(user)
    log.debug(userCreated.toString())
  } catch (e: Exception) {
    log.error(e.cause?.message ?: e.message)
  }
}
