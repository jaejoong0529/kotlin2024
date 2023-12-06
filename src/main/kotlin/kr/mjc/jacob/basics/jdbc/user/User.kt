package kr.mjc.jacob.basics.jdbc.user

data class User(
  var userId: Int? = null,
  var email: String? = null,
  var password: String? = null,
  var name: String? = null
) {
  override fun toString(): String {
    return "\nUser(userId=$userId, email=$email, name=$name)"
  }
}