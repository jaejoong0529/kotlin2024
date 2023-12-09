package kr.mjc.jacob.spring.jdbc.user

import kr.mjc.jacob.basics.jdbc.user.dao.UserDao
import kr.mjc.jacob.spring.jdbc.AppTest
import org.springframework.dao.DataAccessException
import java.util.*

fun main() {
  AppTest().test(UserDao::class.java) { userDao, log ->
    print("Get - userId ? ")
    val userId = Scanner(System.`in`).use { it.nextInt() }
    try {
      val user = userDao.getUser(userId)
      log.debug(user.toString())
    } catch (e: DataAccessException) {
      log.error("회원 없음: userId=$userId")
    }
  }
}
