package kr.mjc.jacob.spring.springjdbc.post

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.post.PostDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import java.util.*

fun main() {
  val postDao = applicationContext.getBean(PostDao::class.java)

  print("List posts - pageNumber(0~) pageSize ? ")
  val page = Scanner(System.`in`).use { Page(it.nextInt(), it.nextInt()) }

  val postList = postDao.list(page)
  postList.forEach(::println)
}