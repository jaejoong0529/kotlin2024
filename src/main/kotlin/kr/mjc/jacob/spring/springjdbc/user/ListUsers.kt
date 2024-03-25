package kr.mjc.jacob.spring.springjdbc.user

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.UserDao
import kr.mjc.jacob.spring.springjdbc.SpringJdbcConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringJdbcConfig::class.java)
  val userDao = context.getBean(UserDao::class.java)

  print("List - pageNumber pageSize ? ")
  val scanner = Scanner(System.`in`)
  val page = Page(scanner.nextInt(), scanner.nextInt())
  scanner.close()

  val userList = userDao.list(page)
  userList.forEach(::println)
}