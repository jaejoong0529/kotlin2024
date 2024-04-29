package kr.mjc.jacob.thymeleaf

import kr.mjc.jacob.spring.jpa.JpaConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.thymeleaf.TemplateEngine
import org.thymeleaf.templatemode.TemplateMode
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

/** 템플릿 엔진을 빈으로 구성한다. */
@ComponentScan(basePackageClasses = [JpaConfig::class])
open class ThymeleafConfig {
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