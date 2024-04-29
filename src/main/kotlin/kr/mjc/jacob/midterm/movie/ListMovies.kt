package kr.mjc.jacob.midterm.movie

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.midterm.applicationContext
import java.util.*

fun main() {
  val movieDao = applicationContext.getBean(MovieDao::class.java)

  print("pageNumber pageSize ? ")
  val page = Scanner(System.`in`).use {
    Page(it.nextInt(), it.nextInt())
  }

  val list = movieDao.findAll(page)
  list.forEach(::println)
}