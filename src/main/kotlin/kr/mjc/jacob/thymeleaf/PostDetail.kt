package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.JpaConfig
import kr.mjc.jacob.spring.jpa.post.PostRepository
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.io.FileWriter
import java.util.*

/** 템플릿 엔진을 빈으로 구성한다. */
@ComponentScan(basePackageClasses = [JpaConfig::class])
open class ThymeleafConfig {
  @Bean
  open fun templateEngine() = TemplateEngine().apply {
    setTemplateResolver(ClassLoaderTemplateResolver().apply {
      prefix = "/templates/"
      suffix = ".html"
    })
  }
}

val applicationContext =
  AnnotationConfigApplicationContext(ThymeleafConfig::class.java)

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
    println("처리 완료")
  }
}