package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Find user - id ? ")
  val id: Long = Scanner(System.`in`).use { it.nextLong() }

  val user = userRepository.findById(id)
  log.info(user.toString())
}