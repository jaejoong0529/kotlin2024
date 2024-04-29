package kr.mjc.jacob.thymeleaf.layout

import kr.mjc.jacob.thymeleaf.applicationContext
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import java.io.FileWriter

fun main() {
  // 템플릿 엔진으로 파일 처리
  val templateEngine = applicationContext.getBean(TemplateEngine::class.java)

  FileWriter("responses/including_fragments.html").use { writer ->
    templateEngine.process("layout/including_fragments", Context(), writer)
    println("Process complete.")
  }
}