package kr.mjc.jacob.jdbc.user

import kr.mjc.jacob.jdbc.Page

interface UserDao {
  fun list(page: Page): List<User>

  fun getById(id: Int): User?

  fun getByUsername(username: String): User?

  fun create(user: User): User?

  fun changePassword(id: Int, password: String)

  fun deleteById(id: Int)
}