package kr.mjc.jacob.spring.springdata.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.spring.springdata.applicationContext
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create - username(email) password first_name ? ")
  val user = Scanner(System.`in`).use {
    User(id = 0, username = it.next(), password = it.next().bcryptHashed,
        firstName = it.next(), dateJoined = LocalDateTime.now())
  }

  if (userRepository.findByUsername(user.username) == null) {
    val userCreated = userRepository.save(user)
    log.info(userCreated.toString())
  } else {
    log.debug("username이 존재합니다.")
  }
}
