package kr.mjc.jacob.springcore.di.javaconfig

import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AppConfig {

  @Bean
  open fun sonySpeaker() = SonySpeaker()

  @Bean
  open fun appleSpeaker() = AppleSpeaker()

  @Bean
  open fun samsungTV() = SamsungTV(sonySpeaker())

  @Bean
  open fun lgTV() = LgTV().apply { speaker = appleSpeaker() }
}

fun main() {
  val log = LoggerFactory.getLogger(AppConfig::class.java)

  AnnotationConfigApplicationContext(AppConfig::class.java).use { context ->
    log.info("빈 구성을 마쳤습니다.")
    context.getBean(SamsungTV::class.java).run {
      volumeUp()
      volumeDown()
    }

    context.getBean(LgTV::class.java).run {
      volumeUp()
      volumeDown()
    }
  }
}
