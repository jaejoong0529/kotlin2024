package kr.mjc.jacob.spring.jdbc.dao

import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.User
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource
import org.springframework.stereotype.Component

@Component
class UserDaoImpl(private val jt: NamedParameterJdbcTemplate) : UserDao {

  private val List_USERS =
    "select userId, email, name from user order by userId desc limit :offset, :count"

  private val GET_USER =
    "select userId, email, password, name from user where userId=:userId"

  private val GET_USER_WITH_EMAIL =
    "select userId, email, password, name from user where userId=:email"

  private val CREATE_USER =
    "insert user(email, password, name) values(:email, :password, :name)"

  private val CHANGE_PASSWORD =
    "update user set password=:password where userId=:userId"

  private val DELETE_USER = "delete from user where userId=:userId"

  private val userRowMapper = BeanPropertyRowMapper(User::class.java)

  override fun listUsers(limit: Limit): List<User> =
    jt.query(List_USERS, BeanPropertySqlParameterSource(limit), userRowMapper)

  override fun getUser(userId: Int): User? =
    jt.queryForObject(GET_USER, SimplePropertySqlParameterSource(userId),
        userRowMapper)

  override fun getUserWithEmail(email: String): User? =
    jt.queryForObject(GET_USER_WITH_EMAIL,
        SimplePropertySqlParameterSource(email), userRowMapper)

  override fun createUser(user: User) {
    jt.update(CREATE_USER, BeanPropertySqlParameterSource(user))
  }

  override fun changePassword(userId: Int, password: String) {
    TODO("Not yet implemented")
  }

  override fun deleteUser(userId: Int) {
    TODO("Not yet implemented")
  }
}