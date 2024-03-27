package kr.mjc.jacob.spring.springdata.user

import kr.mjc.jacob.spring.springdata.applicationContext
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.data.domain.Sort
import java.util.*

fun main() {
  val userRepository = applicationContext.getBean(UserRepository::class.java)

  print("List - pageNumber pageSize ? ")
  val pageable = Scanner(System.`in`).use { scanner ->
    PageRequest.of(scanner.nextInt(), scanner.nextInt(),
        Sort.by(Sort.Direction.DESC, "id"))
  }

  val userSlice: Slice<User> = userRepository.findAll(pageable)
  userSlice.forEach(::println)
}