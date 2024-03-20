package kr.mjc.jacob.jdbc.user.usinghelper

import kr.mjc.jacob.jdbc.Page
import java.util.*

fun main() {
  print("List - pageNumber pageSize ? ")

  val scanner = Scanner(System.`in`)
  val page = Page(scanner.nextInt(), scanner.nextInt())
  scanner.close()

  val userList = UserDaoImpl().list(page)
  userList.forEach(::println)
}