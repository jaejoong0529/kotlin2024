package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.JdbcHelper
import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.PostdbDataSource
import kr.mjc.jacob.jdbc.user.User
import kr.mjc.jacob.jdbc.user.UserDao
import java.sql.ResultSet

class UserDaoImpl : UserDao {

  companion object {
    private const val FIND_ALL =
      "select id, username, password, first_name, date_joined from user order by id desc limit ?,?"

    private const val FIND_BY_ID =
      "select id, username, password, first_name, date_joined from user where id=?"

    private const val FIND_BY_USERNAME =
      "select id, username, password, first_name, date_joined from user where username=?"

    private const val SAVE =
      "insert user(username, password, first_name) values(?, ? ,?) returning *"

    private const val CHANGE_PASSWORD = "update user set password=? where id=?"

    private const val DELETE_BY_ID = "delete from user where id=?"

    private val jdbcHelper = JdbcHelper(PostdbDataSource)

    private fun mapUser(rs: ResultSet): User =
      User(id = rs.getInt("id"), username = rs.getString("username"),
          password = rs.getString("password"),
          firstName = rs.getString("first_name"),
          dateJoined = rs.getTimestamp("date_joined").toLocalDateTime())
  }

  /**
   * 회원 목록
   */
  override fun list(page: Page): List<User> {
    return jdbcHelper.list(FIND_ALL, page.offset, page.size) { rs ->
      mapUser(rs)
    }
  }

  /**
   * 회원 1건 조회
   */
  override fun getById(id: Int): User =
    jdbcHelper.get(FIND_BY_ID, id) { rs -> mapUser(rs) }

  /**
   * 이메일로 회원 조회
   */
  override fun getByUsername(username: String): User =
    jdbcHelper.get(FIND_BY_USERNAME, username) { rs -> mapUser(rs) }

  /**
   * 회원 가입
   */
  override fun create(user: User): User =
    jdbcHelper.get(SAVE, user.username, user.password,
        user.firstName) { rs -> mapUser(rs) }

  /**
   * 비밀번호 변경
   */
  override fun changePassword(id: Int, password: String) {
    jdbcHelper.update(CHANGE_PASSWORD, password, id)
  }

  /**
   * 회원 삭제
   */
  override fun deleteById(id: Int) {
    jdbcHelper.update(DELETE_BY_ID, id)
  }
}