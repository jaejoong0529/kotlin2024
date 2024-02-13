package kr.mjc.jacob.basics.jdbc.user.raw

import kr.mjc.jacob.basics.jdbc.PostDbDataSource
import kr.mjc.jacob.basics.jdbc.user.User
import java.util.*

fun main() {
  print("Get - userId ? ")
  val userId = Scanner(System.`in`).use { it.nextInt() }

  PostDbDataSource.connection.use { conn ->
    conn.prepareStatement(
        "select userId, email, password, name from user where userId=?")
      .use { ps ->
        ps.setInt(1, userId)
        ps.executeQuery().use { rs ->
          if (rs.next()) {
            User(userId = rs.getInt("userId"), email = rs.getString("email"),
                password = rs.getString("password"),
                name = rs.getString("name")).let { println(it) }
          }
        }
      }
  }
}
