package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.JpaConfig
import kr.mjc.jacob.spring.jpa.post.PostRepository
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.io.FileWriter

/** Thymeleaf 템플릿 엔진으로 HTML 프로세싱 */
fun main() {
  val applicationContext =
    AnnotationConfigApplicationContext(JpaConfig::class.java)
  val postRepository = applicationContext.getBean(PostRepository::class.java)

  // Thymeleaf 템플릿 초기화
  val templateEngine = TemplateEngine()
  val templateResolver = ClassLoaderTemplateResolver()
  templateEngine.setTemplateResolver(templateResolver)

  // 컨텍스트(템플릿이 사용하는 데이터 영역) 설정
  val context = Context()
  val posts = postRepository.findAll(
      PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")))
  context.setVariable("posts", posts)

  // 템플릿 엔진으로 파일 처리
  val htmlProcessed =
    templateEngine.process("/templates/post_list.html", context)
  println(htmlProcessed)
  val writer = FileWriter("responses/post_list.html")
  writer.write(htmlProcessed)
  writer.close()
}