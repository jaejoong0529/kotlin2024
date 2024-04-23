package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.post.PostRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import java.io.FileWriter

/** Thymeleaf 템플릿 엔진으로 HTML 프로세싱 */
fun main() {
  val postRepository = applicationContext.getBean(PostRepository::class.java)
  val templateEngine = applicationContext.getBean(TemplateEngine::class.java)

  // 컨텍스트(템플릿이 사용하는 데이터 영역) 설정
  val context = Context()
  val posts = postRepository.findAll(
      PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")))
  context.setVariable("posts", posts)

  // 템플릿 엔진으로 파일 처리
  FileWriter("responses/post_list.html").use { writer ->
    templateEngine.process("post_list", context, writer)
    println("Process complete.")
  }
}