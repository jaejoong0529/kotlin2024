package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Change password - username oldPassword newPassword ? ")
  val scanner = Scanner(System.`in`)
  val username = scanner.next()
  val oldPassword = scanner.next()
  val newPassword = scanner.next()
  scanner.close()

  val user: User? = userRepository.findByUsername(username)
  if (user?.matchPassword(oldPassword) == true) {
    userRepository.changePassword(user.id, newPassword.bcryptHashed)
    log.info("비밀번호를 변경했습니다.")
  } else {
    log.debug("Wrong username or password.")
  }
}
