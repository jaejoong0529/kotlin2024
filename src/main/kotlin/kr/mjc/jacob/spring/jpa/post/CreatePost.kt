package kr.mjc.jacob.spring.jpa.post

import jakarta.persistence.NoResultException
import kr.mjc.jacob.spring.jpa.applicationContext
import kr.mjc.jacob.spring.jpa.user.User
import kr.mjc.jacob.spring.jpa.user.UserRepository
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create Post - username//password//title//content// ? ")
  val scanner = Scanner(System.`in`).useDelimiter("//")
  val username = scanner.next()
  val password = scanner.next()
  val user: User? = userRepository.findByUsername(username)
  if (user == null || !user.matchPassword(password)) {
    scanner.close()
    throw NoResultException("Wrong username or password.")
  }
  val title = scanner.next()
  val content = scanner.next()
  scanner.close()

  val post = Post().apply {
    this.title = title
    this.content = content
    this.user = user
    pubDate = LocalDateTime.now()
    lastModified = LocalDateTime.now()
  }

  postRepository.save(post)
  log.info(post.toString())
}
