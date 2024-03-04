package kr.mjc.jacob.jdbc.user

import org.mindrot.jbcrypt.BCrypt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class User(var id: Int = 0, var username: String = "",
                var password: String = "", var firstName: String = "",
                var dateJoined: LocalDateTime = LocalDateTime.now()) {

  companion object {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
  }

  fun hashPassword(): User {
    password = BCrypt.hashpw(password, BCrypt.gensalt())
    return this
  }

  override fun toString(): String {
    return "User(id=$id, username='$username', firstName='$firstName', dateJoined=${
      dateJoined.format(formatter)
    })"
  }
}