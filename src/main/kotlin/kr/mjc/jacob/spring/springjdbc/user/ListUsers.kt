package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import java.util.*

fun main() {
  val userDao = applicationContext.getBean(UserDao::class.java)

  print("List users - pageNumber(0~) pageSize ? ")
  val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

  val userList = userDao.list(page)
  userList.forEach(::println)
}