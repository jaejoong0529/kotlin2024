package kr.mjc.jacob.springcore.ioc.componentscan

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * p.51 applicationContext.xml을 Java-based configuration으로 수정
 */
@Configuration
@ComponentScan(basePackages = ["kr.mjc.jacob.springcore.ioc.componentscan"])
open class AppConfig

fun main() {
  val log = LoggerFactory.getLogger(object {}.javaClass)

  val context = AnnotationConfigApplicationContext(AppConfig::class.java)
  log.info("빈을 구성했습니다.")

  val samsungTV = context.getBean(SamsungTV::class.java)
  samsungTV.powerOn()
  samsungTV.powerOff()

  val lgTV = context.getBean(LgTV::class.java)
  lgTV.powerOn()
  lgTV.powerOff()
}