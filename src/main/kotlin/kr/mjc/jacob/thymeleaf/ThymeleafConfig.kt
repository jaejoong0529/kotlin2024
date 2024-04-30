package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.JpaConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.thymeleaf.TemplateEngine
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

@Configuration
@Import(JpaConfig::class)
open class ThymeleafConfig {
  /** 템플릿 엔진을 빈으로 구성한다. */
  @Bean
  open fun templateEngine() = TemplateEngine().apply {
    setTemplateResolver(ClassLoaderTemplateResolver().apply {
      prefix = "/templates/"
      suffix = ".html"
      templateMode = TemplateMode.HTML
    })
  }
}

val applicationContext =
  AnnotationConfigApplicationContext(ThymeleafConfig::class.java)

fun main() {
  applicationContext.beanDefinitionNames.forEachIndexed { i, name ->
    println("$i : $name")
  }
}