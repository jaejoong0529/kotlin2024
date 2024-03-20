package kr.mjc.jacob.jdbc.user

import kr.mjc.jacob.jdbc.Page

interface UserRepository {
  fun findAll(page: Page): List<User>

  fun findById(id: Int): User?

  fun findByUsername(username: String): User?

  fun save(user: User): User?

  fun changePassword(id: Int, password: String)

  fun deleteById(id: Int)
}