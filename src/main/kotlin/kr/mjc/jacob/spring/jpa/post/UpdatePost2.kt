package kr.mjc.jacob.spring.jpa.post

import kr.mjc.jacob.spring.jpa.applicationContext
import org.slf4j.LoggerFactory
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

  // 수정할 컬럼만 업데이트
  postRepository.update(id = id, title = title, content = content)
  log.info("Update complete.")
}
