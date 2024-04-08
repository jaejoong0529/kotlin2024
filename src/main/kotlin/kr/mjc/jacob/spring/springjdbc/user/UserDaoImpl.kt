package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.toMap
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class UserDaoImpl(private val template: NamedParameterJdbcTemplate) : UserDao {

  companion object {
    private const val LIST =
      "select id, username, first_name, date_joined from user order by id desc limit :offset, :size"

    private const val GET_BY_ID =
      "select id, username, password, first_name, date_joined from user where id=:id"

    private const val GET_BY_USERNAME =
      "select id, username, password, first_name, date_joined from user where username=:username"

    private const val CREATE =
      "insert user(username, password, first_name) values(:username, :password, :firstName) returning *"

    private const val CHANGE_PASSWORD =
      "update user set password=:password where id=:id"

    private const val DELETE_BY_ID = "delete from user where id=:id"
  }

  /**
   * resultSet의 컬럼을 bean의 property에 자동 매핑
   */
  private val userRowMapper = BeanPropertyRowMapper(User::class.java)

  override fun list(page: Page): List<User> =
    template.query(LIST, page.toMap, userRowMapper)

  /**
   * @exception EmptyResultDataAccessException 사용자가 없을 경우
   */
  override fun getById(id: Int): User? =
    template.queryForObject(GET_BY_ID, mapOf("id" to id), userRowMapper)

  /**
   * @exception EmptyResultDataAccessException 사용자가 없을 경우
   */
  override fun getByUsername(username: String): User? =
    template.queryForObject(GET_BY_USERNAME, mapOf("username" to username),
        userRowMapper)

  /**
   * @exception DuplicateKeyException username이 중복일 경우
   */
  override fun create(user: User): User? =
    template.queryForObject(CREATE, user.toMap, userRowMapper)

  override fun changePassword(id: Int, password: String) =
    template.update(CHANGE_PASSWORD, mapOf("id" to id, "password" to password))

  override fun deleteById(id: Int) =
    template.update(DELETE_BY_ID, mapOf("id" to id))
}