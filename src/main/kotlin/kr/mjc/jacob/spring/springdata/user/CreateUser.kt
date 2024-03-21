package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.springdata.SpringDataConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringDataConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create - username(email) password first_name ? ")
  val user = Scanner(System.`in`).use {
    User(username = it.next(), password = it.next().bcryptHashed,
        firstName = it.next())
  }

  if (userRepository.findByUsername(user.username) == null) {
    val userCreated = userRepository.save(user)
    log.info(userCreated.toString())
  } else {
    log.debug("username이 존재합니다.")
  }
}
