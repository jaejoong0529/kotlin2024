package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.SpringDataConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringDataConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Delete - username password ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val password = scanner.next()
  scanner.close()

  val user = userRepository.findByUsername(username)
  if (user?.matchPassword(password) == true) {
    userRepository.deleteById(user.id)
    log.info("삭제했습니다.")
  } else {
    log.debug("Wrong username or password.")
  }
}