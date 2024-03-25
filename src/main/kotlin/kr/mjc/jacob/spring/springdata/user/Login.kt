package kr.mjc.jacob.spring.springdata.user

import kr.mjc.jacob.spring.springdata.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Login - username(email) password ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val password = scanner.next()
  scanner.close()

  val user = userRepository.findByUsername(username)
  if (user?.matchPassword(password) == true) log.info(user.toString())
  else log.debug("Wrong username or password.")
}
