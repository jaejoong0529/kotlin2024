package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.PostdbDataSource
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("List - pageNumber pageSize ? ")
  val scanner = Scanner(System.`in`)
  val page = Page(scanner.nextInt(), scanner.nextInt())
  scanner.close()

  val sql =
    "select id, username, first_name, date_joined from user order by id desc limit ?,?"
  val userList = mutableListOf<User>()
  PostdbDataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, page.offset)
      ps.setInt(2, page.size)

      ps.executeQuery().use { rs ->
        while (rs.next()) {
          val user =
            User(id = rs.getInt("id"), username = rs.getString("username"),
                firstName = rs.getString("first_name"),
                dateJoined = rs.getTimestamp("date_joined").toLocalDateTime())
          userList.add(user)
        }
      }
    }
  }
  println(userList)
}