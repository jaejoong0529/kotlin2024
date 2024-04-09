package kr.mjc.jacob.spring.jpa.post

import jakarta.persistence.NoResultException
import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Update Post - id//title//content// ? ")
  val scanner = Scanner(System.`in`).useDelimiter("//")
  val id = scanner.nextLong()
  val title = scanner.next()
  val content = scanner.next()
  scanner.close()

  // DB에서 글을 가져와서 속성을 일부 수정후 다시 저장
  val post = postRepository.findById(id)
    .orElseThrow { NoResultException("Post not found") }
  post.title = title
  post.content = content
  post.lastModified = LocalDateTime.now()

  postRepository.save(post)
  log.info("Update complete.")
}
