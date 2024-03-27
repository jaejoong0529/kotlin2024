package kr.mjc.jacob.spring.springdata.user

import kr.mjc.jacob.formatted
import org.mindrot.jbcrypt.BCrypt
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class User(@Id val id: Int = 0, val username: String, var password: String,
                val firstName: String,
                val dateJoined: LocalDateTime = LocalDateTime.now()) {

  /**
   * @param password 평문 비밀번호
   * @return 평문 비밀번호와 user의 비밀번호가 매치하면 true 아니면 false
   */
  fun matchPassword(password: String): Boolean =
    BCrypt.checkpw(password, this.password)

  override fun toString(): String {
    return "User(id=$id, username='$username', firstName='$firstName', dateJoined=${
      dateJoined.formatted
    })"
  }
}