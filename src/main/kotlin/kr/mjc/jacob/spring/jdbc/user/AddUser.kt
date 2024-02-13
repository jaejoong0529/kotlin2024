package kr.mjc.jacob.spring.jdbc.user

import kr.mjc.jacob.basics.jdbc.user.User
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao
import kr.mjc.jacob.spring.jdbc.AppTest
import org.springframework.dao.DataAccessException
import java.util.*

fun main() {
  AppTest().test(UserDao::class.java) { userDao, log ->
    print("Get - email password name ? ")
    val user = User().apply {
      Scanner(System.`in`).use {
        email = it.next()
        password = it.next()
        name = it.next()
      }
    }
    try {
      userDao.createUser(user)
      log.debug(user.toString())
    } catch (_: DataAccessException) {
    }
  }
}
