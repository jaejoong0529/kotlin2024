package kr.mjc.jacob.basics.jdbc.user.raw

import kr.mjc.jacob.basics.jdbc.Web2DataSource
import kr.mjc.jacob.basics.jdbc.user.User
import java.util.*

fun main() {
  print("Get - userId ? ")
  val userId = Scanner(System.`in`).use { it.nextInt() }

  Web2DataSource.connection.use { conn ->
    conn.prepareStatement("select userId, email, name from user where userId=?")
      .use { ps ->
        ps.setInt(1, userId)
        ps.executeQuery().use { rs ->
          if (rs.next()) {
            User(
              userId = rs.getInt("userId"),
              email = rs.getString("email"),
              name = rs.getString("name")
            ).let { println(it) }
          }
        }
      }
  }
}
