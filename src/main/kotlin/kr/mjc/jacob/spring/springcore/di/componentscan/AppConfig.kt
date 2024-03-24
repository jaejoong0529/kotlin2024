package kr.mjc.jacob.spring.springcore.di.componentscan

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["kr.mjc.jacob.springcore.di.componentscan"])
open class AppConfig

fun main() {
  val log = LoggerFactory.getLogger(
      AppConfig::class.java)

  AnnotationConfigApplicationContext(
      AppConfig::class.java).use { context ->
    log.info("빈 구성을 마쳤습니다.")
    context.getBean(
        SamsungTV::class.java)
      .run {
        volumeUp()
        volumeDown()
      }

    context.getBean(
        LgTV::class.java).run {
      volumeUp()
      volumeDown()
    }
  }
}
