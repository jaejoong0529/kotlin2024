package kr.mjc.jacob.springjdbc.user

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.map
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserDaoImpl(private val template: NamedParameterJdbcTemplate) :
    UserDao {

  companion object {
    private const val FIND_ALL =
      "select id, username, password, first_name, date_joined from user order by id desc limit :offset, :size"

    private const val FIND_BY_ID =
      "select id, username, password, first_name, date_joined from user where id=:id"

    private const val FIND_BY_USERNAME =
      "select id, username, password, first_name, date_joined from user where id=:username"

    private const val SAVE =
      "insert user(username, password, first_name) values(:username, :password, :firstName) returning *"

    private const val CHANGE_PASSWORD =
      "update user set password=:password where id=:id"

    private const val DELETE_BY_ID = "delete from user where id=:id"

    private val userRowMapper = BeanPropertyRowMapper(User::class.java)
  }

  override fun list(page: Page): List<User> =
    template.query(FIND_ALL, page.map, userRowMapper)

  override fun getById(id: Int): User? =
    template.queryForObject(FIND_BY_ID, mapOf("id" to id), userRowMapper)

  override fun getByUsername(username: String): User? =
    template.queryForObject(FIND_BY_USERNAME, mapOf("username" to username),
        userRowMapper)

  override fun create(user: User): User? =
    template.queryForObject(SAVE, user.map, userRowMapper)

  override fun changePassword(id: Int, password: String) {
    template.update(CHANGE_PASSWORD, mapOf("id" to id, "password" to password))
  }

  override fun deleteById(id: Int) {
    template.update(DELETE_BY_ID, mapOf("id" to id))
  }
}