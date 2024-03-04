package kr.mjc.jacob.jdbc.user.raw

import kr.mjc.jacob.jdbc.Postdb
import kr.mjc.jacob.jdbc.user.User
import java.util.*

fun main() {
  print("Get - username(username) password first_name ? ")
  val scanner = Scanner(System.`in`)
  val user = User(username = scanner.next(), password = scanner.next(),
      firstName = scanner.next()).hashPassword()
  scanner.close()
  val sql = "insert user(username, password, first_name) values(?, ?, ?)"
  Postdb.connection.use { conn ->
    conn.prepareStatement(sql).use { ps ->
      ps.setString(1, user.username)
      ps.setString(2, user.password)
      ps.setString(3, user.firstName)
      ps.executeUpdate()
      println("저장 완료")
    }
  }
}
