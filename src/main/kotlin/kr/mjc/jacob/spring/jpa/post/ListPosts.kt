package kr.mjc.jacob.spring.jpa.post

import kr.mjc.jacob.spring.jpa.applicationContext
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)

  print("List Posts - pageNumber pageSize ? ")
  val pageable = Scanner(System.`in`).use { scanner ->
    PageRequest.of(scanner.nextInt(), scanner.nextInt(),
        Sort.by(Sort.Direction.DESC, "id"))
  }

  val page: Page<Post> = postRepository.findAll(pageable)
  page.forEach(::println)
}