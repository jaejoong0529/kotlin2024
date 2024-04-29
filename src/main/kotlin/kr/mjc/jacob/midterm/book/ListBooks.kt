package kr.mjc.jacob.midterm.book

import kr.mjc.jacob.midterm.applicationContext
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val bookRepository = applicationContext.getBean(BookRepository::class.java)

  print("pageNumber pageSize ? ")
  val page = Scanner(System.`in`).use {
    PageRequest.of(it.nextInt(), it.nextInt(),
                   Sort.by(Sort.Direction.DESC, "id"))
  }

  val list = bookRepository.findAll(page)
  list.forEach(::println)
}