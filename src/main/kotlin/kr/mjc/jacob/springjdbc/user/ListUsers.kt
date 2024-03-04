package kr.mjc.jacob.springjdbc.user

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.user.usinghelper.UserRepository
import kr.mjc.jacob.springjdbc.AppConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)

  print("List - pageNumber pageSize ? ")
  val scanner = Scanner(System.`in`)
  val page = Page(scanner.nextInt(), scanner.nextInt())
  scanner.close()

  val userList = userRepository.findAll(page)
  println(userList)
}