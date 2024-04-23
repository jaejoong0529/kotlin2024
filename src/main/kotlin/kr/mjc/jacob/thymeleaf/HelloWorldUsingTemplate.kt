package kr.mjc.jacob.thymeleaf

import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver
import java.io.FileWriter
import java.util.*

/** Thymeleaf 템플릿 엔진으로 HTML 프로세싱 */
fun main() {
  // Thymeleaf 템플릿 엔진 초기화
  val templateEngine = TemplateEngine()
  val templateResolver = ClassLoaderTemplateResolver()
  templateResolver.templateMode = TemplateMode.HTML
  templateEngine.setTemplateResolver(templateResolver)

  print("name ? ")
  val name = Scanner(System.`in`).use { it.next() }

  // 컨텍스트(템플릿이 사용하는 데이터 영역) 설정
  val context = Context()
  context.setVariable("name", name)

  // 템플릿 엔진으로 파일 처리
  FileWriter("responses/hello_world.html").use { writer ->
    templateEngine.process("/templates/hello_world.html", context, writer)
    println("Process complete.")
  }
}