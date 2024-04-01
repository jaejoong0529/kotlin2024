package kr.mjc.jacob.jdbc.post.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.post.Post
import java.util.*

fun main() {
  print("Get - id ? ")
  val id = Scanner(System.`in`).use { it.nextInt() }
  val sql =
    "select id, title, content, user_id, first_name, pub_date, id, title, content, user_id, first_name, pub_date, last_modified from post where id=?"

  DataSourceFactory.dataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, id)
      ps.executeQuery().use { rs ->
        if (rs.next()) {
          val post = Post(id = rs.getInt("id"), title = rs.getString("title"),
              content = rs.getString("content"), userId = rs.getInt("user_id"),
              firstName = rs.getString("first_name"),
              pubDate = rs.getTimestamp("pub_date").toLocalDateTime(),
              lastModified = rs.getTimestamp("last_modified").toLocalDateTime())
          println(post)
        } else {
          println("포스트 없음")
        }
      }
    }
  }
}
