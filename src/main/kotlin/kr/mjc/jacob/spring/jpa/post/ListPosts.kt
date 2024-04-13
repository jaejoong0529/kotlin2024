package kr.mjc.jacob.spring.jpa.post

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("List Posts - pageNumber(0~) pageSize ? ")
  val pageable = Scanner(System.`in`).use {
    PageRequest.of(it.nextInt(), it.nextInt(),
        Sort.by(Sort.Direction.DESC, "id"))
  }

  val page: Page<Post> = postRepository.findAll(pageable)
  page.forEach { post ->
    println(
        "id=${post.id}, title=${post.title}, user(id=${post.user.id}, username=${post.user.username})")
  }
  log.info("isFirst={}, isLast={}, totalElements={}, totalPages={}",
      page.isFirst, page.isLast, page.totalElements, page.totalPages)
}