package kr.mjc.jacob.spring.jpa.user

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)
  val log = LoggerFactory.getLogger({}.javaClass)

  print("List users - pageNumber(0~) pageSize ? ")
  val pageable = Scanner(System.`in`).use {
    PageRequest.of(it.nextInt(), it.nextInt(),
        Sort.by(Sort.Direction.DESC, "id"))
  }

  val userPage: Page<User> = userRepository.findAll(pageable)
  userPage.forEach(::println)
  log.info("isFirst={}, isLast={}, totalElements={}, totalPages={}",
      userPage.isFirst, userPage.isLast, userPage.totalElements,
      userPage.totalPages)
}
