package kr.mjc.jacob.basics.jdbc.user

import org.mindrot.jbcrypt.BCrypt

data class User(var userId: Int? = null, var email: String? = null,
                var password: String? = null, var name: String? = null) {

  val passwordHashed: String get() = BCrypt.hashpw(password, BCrypt.gensalt())
}