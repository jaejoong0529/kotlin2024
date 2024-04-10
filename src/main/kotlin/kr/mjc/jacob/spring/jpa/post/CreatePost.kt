package kr.mjc.jacob.spring.jpa.post

import jakarta.persistence.NoResultException
import kr.mjc.jacob.spring.jpa.applicationContext
import kr.mjc.jacob.spring.jpa.user.User
import kr.mjc.jacob.spring.jpa.user.UserRepository
import kr.mjc.jacob.spring.jpa.user.UserService
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create post - username(email)//password//title//content// ? ")
  val (username, password, title, content) = Scanner(System.`in`).useDelimiter(
      "//").use {
    arrayOf(it.next().trim(), it.next().trim(), it.next().trim(),
        it.next().trim())
  }

  val user = userService.login(username, password) ?: return

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
