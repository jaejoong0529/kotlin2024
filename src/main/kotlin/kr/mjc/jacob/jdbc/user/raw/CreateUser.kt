package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.bcryptHashed
import kr.mjc.jacob.jdbc.DataSourceFactory
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Create - username(username) password first_name ? ")
  val user = Scanner(System.`in`).use { scanner ->
    User(username = scanner.next(), password = scanner.next().bcryptHashed,
        firstName = scanner.next())
  }
  val sql = "insert user(username, password, first_name) values(?, ?, ?)"
  try {
    DataSourceFactory.dataSource.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        ps.setString(1, user.username)
        ps.setString(2, user.password)
        ps.setString(3, user.firstName)
        ps.executeUpdate()
        println("저장 완료")
      }
    }
  } catch (e: Exception) {
    println(e.message)
  }
}
