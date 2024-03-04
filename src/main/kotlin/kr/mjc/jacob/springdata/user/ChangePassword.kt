package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.AppConfig
import org.mindrot.jbcrypt.BCrypt
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger(object {}.javaClass.enclosingClass)

  print("Change password - id oldPassword newPassword ? ")
  val scanner = Scanner(System.`in`)
  val id = scanner.nextInt()
  val oldPassword = scanner.next()
  val newPassword = scanner.next()
  scanner.close()

  try {
    val user = userRepository.findById(id).orElseThrow()
    if (BCrypt.checkpw(oldPassword, user.password)) { // plain, hashed
      userRepository.changePassword(id,
          BCrypt.hashpw(newPassword, BCrypt.gensalt()))
      log.debug("비밀번호를 변경했습니다.")
    } else {
      log.debug("비밀번호가 다릅니다.")
    }
  } catch (e: Exception) {
    log.error("사용자가 없습니다. id=$id")
  }
}
