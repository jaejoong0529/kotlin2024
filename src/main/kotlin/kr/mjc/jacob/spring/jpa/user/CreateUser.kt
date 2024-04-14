package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create user - username(email) password firstName ? ")
  val user = Scanner(System.`in`).use {
    User().apply {
      username = it.next()
      password = it.next().bcryptHashed
      firstName = it.next()
      dateJoined = LocalDateTime.now()
      lastLogin = dateJoined
    }
  }

  if (userRepository.findByUsername(user.username) == null) {
    userRepository.save(user)
    log.info(user.toString())
  } else {
    log.debug("username이 존재합니다.")
  }
}
