package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.spring.jpa.applicationContext
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)

  print("List Users - pageNumber pageSize ? ")
  val pageable = Scanner(System.`in`).use { scanner ->
    PageRequest.of(scanner.nextInt(), scanner.nextInt(),
        Sort.by(Sort.Direction.DESC, "id"))
  }

  val userPage: Page<User> = userRepository.findAll(pageable)
  userPage.forEach(::println)
}