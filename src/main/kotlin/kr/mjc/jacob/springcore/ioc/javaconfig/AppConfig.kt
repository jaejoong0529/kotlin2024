package kr.mjc.jacob.springcore.ioc.javaconfig

import kr.mjc.jacob.springcore.ioc.beanfactory.LgTV
import kr.mjc.jacob.springcore.ioc.beanfactory.SamsungTV
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * p.51 applicationContext.xml을 Java-based configuration으로 수정
 */
@Configuration
open class AppConfig {
  @Bean
  open fun samsungTV() = SamsungTV()

  @Bean
  open fun lgTVTV() = LgTV()
}

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

