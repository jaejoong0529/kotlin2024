package kr.mjc.jacob.spring.springjdbc.post

import kr.mjc.jacob.jdbc.post.Post
import kr.mjc.jacob.jdbc.post.PostDao
import kr.mjc.jacob.spring.springjdbc.applicationContext
import kr.mjc.jacob.spring.springjdbc.user.UserService
import org.slf4j.LoggerFactory
import java.util.*

fun main() {
  val postDao = applicationContext.getBean(PostDao::class.java)
  val userService = applicationContext.getBean(UserService::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("Create post - username(email)//password//title//content// ? ")
  val (username, password, title, content) = Scanner(System.`in`).useDelimiter(
      "//").use {
    arrayOf(it.next().trim(), it.next().trim(), it.next().trim(),
        it.next().trim())
  }

  val user = userService.login(username, password) ?: return

  val postCreated = postDao.create(
      Post(title = title, content = content, userId = user.id,
          firstName = user.firstName))
  log.info(postCreated.toString())
}
