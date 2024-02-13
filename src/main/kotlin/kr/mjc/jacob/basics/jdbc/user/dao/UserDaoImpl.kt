package kr.mjc.jacob.basics.jdbc.user.dao

import kr.mjc.jacob.basics.jdbc.JdbcHelper
import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.PostDbDataSource
import kr.mjc.jacob.basics.jdbc.user.User
import java.sql.ResultSet

class UserDaoImpl : UserDao {

  companion object {
    private const val LIST_USERS =
      "select userId, email, name from user order by userId desc limit ?,?"

    private const val GET_USER =
      "select userId, email, password, name from user where userId=?"

    private const val GET_USER_WITH_EMAIL =
      "select userId, email, password, name from user where email=?"

    private const val CREATE_USER =
      "insert user(email, password, name) values(?, ? ,?)"

    private const val CHANGE_PASSWORD =
      "update user set password=? where userId=?"

    private const val DELETE_USER = "delete from user where userId=?"
  }

  private val jdbcHelper = JdbcHelper(PostDbDataSource)

  private fun mapUser(rs: ResultSet): User =
    User(userId = rs.getInt("userId"), email = rs.getString("email"),
        password = rs.getString("password"), name = rs.getString("name"))

  /**
   * 회원 목록
   */
  override fun listUsers(limit: Limit): List<User> =
    jdbcHelper.list(LIST_USERS, limit.offset, limit.count) { rs -> mapUser(rs) }

  /**
   * 회원 1건 조회
   */
  override fun getUser(userId: Int): User =
    jdbcHelper.get(GET_USER, userId) { rs -> mapUser(rs) }

  /**
   * 이메일로 회원 조회
   */
  override fun getUserWithEmail(email: String): User =
    jdbcHelper.get(GET_USER_WITH_EMAIL, email) { rs -> mapUser(rs) }

  /**
   * 회원 가입
   */
  override fun createUser(user: User) {
    jdbcHelper.update(CREATE_USER, user.email, user.password, user.name)
  }

  /**
   * 비밀번호 변경
   */
  override fun changePassword(userId: Int, password: String) {
    jdbcHelper.update(CHANGE_PASSWORD, password, userId)
  }

  /**
   * 회원 삭제
   */
  override fun deleteUser(userId: Int) {
    jdbcHelper.update(DELETE_USER, userId)
  }
}