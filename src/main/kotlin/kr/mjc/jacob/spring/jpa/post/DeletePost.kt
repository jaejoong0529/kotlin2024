package kr.mjc.jacob.spring.jpa.post

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Delete post - id ? ")
  val id = Scanner(System.`in`).use { it.nextLong() }

  postRepository.deleteById(id)
  log.info("Delete complete.")
}