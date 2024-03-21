package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.SpringDataConfig
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*
import kotlin.jvm.optionals.getOrNull

fun main() {
  val context = AnnotationConfigApplicationContext(SpringDataConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Find - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }
  val user = userRepository.findById(id).getOrNull()
  log.info(user.toString())
}
