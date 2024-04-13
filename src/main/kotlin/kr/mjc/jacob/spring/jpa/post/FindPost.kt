package kr.mjc.jacob.spring.jpa.post

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Find post - id ? ")
  val id: Long = Scanner(System.`in`).use { it.nextLong() }

  val post: Optional<Post> = postRepository.findById(id)
  log.info(post.toString())
}