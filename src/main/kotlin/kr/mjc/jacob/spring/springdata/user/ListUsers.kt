package kr.mjc.jacob.springdata.user

import kr.mjc.jacob.springdata.SpringDataConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val context = AnnotationConfigApplicationContext(SpringDataConfig::class.java)
  val userRepository = context.getBean(UserRepository::class.java)

  print("List - pageNumber pageSize ? ")
  val scanner = Scanner(System.`in`)
  val pageable = PageRequest.of(scanner.nextInt(), scanner.nextInt(),
      Sort.by(Sort.Direction.DESC, "id"))
  scanner.close()

  val userList = userRepository.findAll(pageable)
  userList.forEach(::println)
}