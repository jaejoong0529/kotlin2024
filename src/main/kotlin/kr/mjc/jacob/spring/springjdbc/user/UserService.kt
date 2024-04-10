package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.UserDao
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Component

@Component
class UserService(private val userDao: UserDao) {
  private val log = LoggerFactory.getLogger(this.javaClass)

  fun login(username: String, password: String): User? {
    return try {
      val user: User? = userDao.getByUsername(username)
      if (user?.matchPassword(password) == true) user else {
        log.error("Wrong password.")
        null
      }
    } catch (e: EmptyResultDataAccessException) {
      log.error("No user.")
      null
    }
  }
}