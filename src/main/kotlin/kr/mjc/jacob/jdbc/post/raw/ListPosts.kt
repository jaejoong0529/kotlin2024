package kr.mjc.jacob.jdbc.post.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.post.Post
import java.util.*

fun main() {
  print("List - pageNumber pageSize ? ")
  val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

  val sql =
    "select id, title, user_id, first_name, pub_date, last_modified from post order by id desc limit ?,?"

  val postList = mutableListOf<Post>()
  DataSourceFactory.dataSource.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setInt(1, page.offset)
      ps.setInt(2, page.size)

      ps.executeQuery().use { rs ->
        while (rs.next()) {
          val post = Post(id = rs.getInt("id"), title = rs.getString("title"),
              userId = rs.getInt("user_id"),
              firstName = rs.getString("first_name"),
              pubDate = rs.getTimestamp("pub_date").toLocalDateTime(),
              lastModified = rs.getTimestamp("last_modified")
                .toLocalDateTime()); postList.add(post)
        }
      }
    }
  }
  postList.forEach(::println)
}