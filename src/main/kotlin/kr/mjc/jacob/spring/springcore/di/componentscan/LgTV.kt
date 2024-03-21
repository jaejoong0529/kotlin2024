package kr.mjc.jacob.spring.springcore.di.componentscan

import kr.mjc.jacob.spring.springcore.ioc.beanfactory.TV
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

/**
 * p.43 LgTV.java
 */
@Component
class LgTV : TV {

  private val log = LoggerFactory.getLogger(this.javaClass)

  @Qualifier("appleSpeaker") @Autowired lateinit var speaker: Speaker

  override fun powerOn() {
    log.debug("lgTV power on.")
  }

  override fun powerOff() {
    log.debug("lgTV power off.")
  }

  override fun volumeUp() {
    speaker.volumeUp()
  }

  override fun volumeDown() {
    speaker.volumeDown()
  }
}