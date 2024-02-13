package kr.mjc.jacob.basics.jdbc.user.raw

import kr.mjc.jacob.basics.jdbc.PostDbDataSource
import kr.mjc.jacob.basics.jdbc.user.User
import java.sql.Statement

import java.util.*

fun main() {
  print("Get - email password name ? ")
  val user = User().apply {
    Scanner(System.`in`).use {
      email = it.next()
      password = it.next()
      name = it.next()
    }
  }

  PostDbDataSource.connection.use { conn ->
    conn.prepareStatement("insert user(email, password, name) values(?, ?, ?)",
        Statement.RETURN_GENERATED_KEYS).use { ps ->
      ps.setString(1, user.email)
      ps.setString(2, user.passwordHashed)
      ps.setString(3, user.name)
      ps.executeUpdate()
      println(user)
    }
  }
}
