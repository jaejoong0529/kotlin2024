package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.JdbcHelper
import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.Web2DataSource
import kr.mjc.jacob.basics.jdbc.user.User
import java.sql.ResultSet

object UserDaoImpl : UserDao {

  private val List_USERS =
    "select userId, email, name from user order by userId desc limit ?,?"

  private val GET_USER = "select userId, email, name from user where userId=?"

  private val LOGIN =
    "select userId, email, name from user where email=? and password=sha2(?,256)"

  private val ADD_USER =
    "insert user(email, password, name) values(?,sha2(?,256),?)"

  private val UPDATE_PASSWORD =
    "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)"

  private val DELETE_USER =
    "delete from user where userId=? and password=sha2(?,256)"

  private val jdbcHelper = JdbcHelper(Web2DataSource)

  fun mapUser(rs: ResultSet): User = User(
    userId = rs.getInt("userId"),
    email = rs.getString("email"),
    name = rs.getString("name")
  )

  /**
   * 회원 목록
   */
  override fun listUsers(limit: Limit): List<User> =
    jdbcHelper.list(List_USERS, limit.offset, limit.count) { rs -> mapUser(rs) }

  /**
   * 회원 1건 조회
   */
  override fun getUser(userId: Int): User? =
    jdbcHelper.get(GET_USER, userId) { rs -> mapUser(rs) }

  /**
   * 회원 가입
   */
  override fun addUser(user: User) {
    user.userId =
      jdbcHelper.insert(ADD_USER, user.email, user.password, user.name)
  }
}