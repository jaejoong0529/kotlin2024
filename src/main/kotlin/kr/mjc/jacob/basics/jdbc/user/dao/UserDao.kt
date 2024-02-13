package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.User

interface UserDao {
  fun listUsers(limit: Limit): List<User>

  fun getUser(userId: Int): User?

  fun getUserWithEmail(email: String): User?

  fun createUser(user: User)

  fun changePassword(userId: Int, password: String)

  fun deleteUser(userId: Int)
}