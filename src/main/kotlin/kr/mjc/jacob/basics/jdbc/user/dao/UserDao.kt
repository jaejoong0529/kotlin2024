package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.User

interface UserDao {
  fun listUsers(limit: Limit): List<User>

  fun getUser(userId: Int): User?

  fun addUser(user: User)
}