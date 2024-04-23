package kr.mjc.jacob.midterm.book

import kr.mjc.jacob.midterm.applicationContext
import java.util.*

fun main() {
  val bookDao = applicationContext.getBean(BookDao::class.java)

  val book: Book = Scanner(System.`in`).use {
    Book().apply {
      print("title ? ")
      title = it.nextLine()
      print("director ? ")
      author = it.nextLine()
    }
  }

  bookDao.save(book)
  println(book)
}