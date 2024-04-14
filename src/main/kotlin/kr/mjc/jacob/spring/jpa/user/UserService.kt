package kr.mjc.jacob.spring.jpa.user

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class UserService(private val userRepository: UserRepository) {
  private val log = LoggerFactory.getLogger(this.javaClass)

  fun login(username: String, password: String): User? {
    val user: User? = userRepository.findByUsername(username)
    return if (user?.matchPassword(password) == true) {
      val lastLogin = LocalDateTime.now()
      userRepository.updateLastLogin(user.id, lastLogin)
      user.apply { this.lastLogin = lastLogin }
    } else {
      log.error("Wrong username or password.")
      null
    }
  }
}