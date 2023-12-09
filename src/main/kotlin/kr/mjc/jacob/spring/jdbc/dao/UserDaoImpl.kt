package kr.mjc.jacob.spring.jdbc.dao

import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.User
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Component

@Component
class UserDaoImpl(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) :
  UserDao {

  private val jdbcTemplate = namedParameterJdbcTemplate.jdbcTemplate

  private val List_USERS =
    "select userId, email, name from user order by userId desc limit ?,?"

  private val GET_USER = "select userId, email, name from user where userId=?"

  private val LOGIN =
    "select userId, email, name from user where email=? and password=sha2(?,256)"

  private val ADD_USER =
    "insert user(email, password, name) values(:email, sha2(:password,256), :name)"

  private val UPDATE_PASSWORD =
    "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)"

  private val DELETE_USER =
    "delete from user where userId=? and password=sha2(?,256)"

  private val userRowMapper = BeanPropertyRowMapper(User::class.java)

  override fun listUsers(limit: Limit): List<User> =
    jdbcTemplate.query(List_USERS, userRowMapper, limit.offset, limit.count)

  override fun getUser(userId: Int): User? =
    jdbcTemplate.queryForObject(GET_USER, userRowMapper, userId)

  override fun addUser(user: User) {
    val keyHolder = GeneratedKeyHolder()
    namedParameterJdbcTemplate.update(
      ADD_USER, BeanPropertySqlParameterSource(user), keyHolder
    )
    user.userId = keyHolder.key?.toInt()
  }
}