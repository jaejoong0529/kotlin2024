package kr.mjc.jacob.spring.jdbc.user

import kr.mjc.jacob.basics.jdbc.Limit
import kr.mjc.jacob.basics.jdbc.user.dao.UserDao
import kr.mjc.jacob.spring.jdbc.AppTest
import java.util.*

fun main() {
  AppTest().test(UserDao::class.java) { userDao, log ->
    print("List - count page ? ")
    val limit = Limit().apply {
      Scanner(System.`in`).use {
        count = it.nextInt()
        page = it.nextInt()
      }
    }
    val userList = userDao.listUsers(limit)
    log.debug(userList.toString())
  }
}