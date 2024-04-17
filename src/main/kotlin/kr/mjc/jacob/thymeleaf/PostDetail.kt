package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.post.PostRepository
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import java.io.FileWriter
import java.util.*

fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val templateEngine = applicationContext.getBean(TemplateEngine::class.java)

  // 컨텍스트(템플릿이 사용하는 데이터 영역) 설정
  print("Post Detail - id ? ")
  val id = Scanner(System.`in`).use { it.nextLong() }
  val context = Context()
  val post = postRepository.findById(id).orElseThrow()
  context.setVariable("post", post)

  // 템플릿 엔진으로 파일 처리
  FileWriter("responses/post_detail.html").use { writer ->
    templateEngine.process("post_detail", context, writer)
    println("Process complete.")
  }
}