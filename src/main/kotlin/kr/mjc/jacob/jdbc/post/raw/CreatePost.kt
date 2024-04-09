package kr.mjc.jacob.jdbc.post.raw

import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.post.Post
import java.util.*

fun main() {
  print("Create - title//content//userId//firstName// ? ")
  val post = Scanner(System.`in`).useDelimiter("//").use {
    Post(title = it.next(), content = it.next(), userId = it.nextInt(),
        firstName = it.next())
  }

  println(post)
  val sql =
    "insert post(title, content, user_id, first_name) values(?, ?, ?, ?)"
  try {
    DataSourceFactory.dataSource.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        ps.setString(1, post.title)
        ps.setString(2, post.content)
        ps.setInt(3, post.userId)
        ps.setString(4, post.firstName)
        ps.executeUpdate()
        println("저장 완료")
      }
    }
  } catch (e: Exception) {
    println(e.message)
  }
}
