package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.jdbc.PostdbDataSource
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }
  val sql =
    "select id, username, password, first_name, date_joined from user where id=?"

  PostdbDataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, id)
      ps.executeQuery().use { rs ->
        if (rs.next()) {
          val user =
            User(id = rs.getInt("id"), username = rs.getString("username"),
                password = rs.getString("password"),
                firstName = rs.getString("first_name"),
                dateJoined = rs.getTimestamp("date_joined").toLocalDateTime())
          println(user)
        } else {
          println("사용자 없음")
        }
      }
    }
  }
}
