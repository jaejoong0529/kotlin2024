package kr.mjc.jacob.spring.springdata.user

import kr.mjc.jacob.spring.springdata.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Find - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }
  val user: User? = userRepository.findById(id)
  log.info(user.toString())
}
