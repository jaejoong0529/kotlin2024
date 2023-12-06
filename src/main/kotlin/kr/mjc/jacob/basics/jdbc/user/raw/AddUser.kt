package kr.mjc.jacob.basics.jdbc.user.raw

import kr.mjc.jacob.basics.jdbc.Web2DataSource
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

  Web2DataSource.connection.use { conn ->
    conn.prepareStatement(
      "insert user(email, password, name) values(?,sha2(?,256),?)",
      Statement.RETURN_GENERATED_KEYS
    ).use { ps ->
      ps.setString(1, user.email)
      ps.setString(2, user.password)
      ps.setString(3, user.name)
      ps.executeUpdate()
      val keys = ps.generatedKeys
      if (keys.next()) user.userId = keys.getInt(1)
      println(user)
    }
  }
}
