package kr.mjc.jacob.springdata.user

import org.mindrot.jbcrypt.BCrypt
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class User(@Id val id: Int = 0, val username: String = "",
                var password: String = "", val firstName: String = "",
                val dateJoined: LocalDateTime = LocalDateTime.now()) {

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