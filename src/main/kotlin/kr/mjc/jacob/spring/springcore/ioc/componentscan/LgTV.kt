package kr.mjc.jacob.spring.springcore.ioc.componentscan

import kr.mjc.jacob.spring.springcore.ioc.beanfactory.TV
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * p.43 LgTV.java
 */
@Component
class LgTV : TV {

  private val log = LoggerFactory.getLogger(this.javaClass)

  init {
    log.debug("lgTV 인스턴스 생성됨.")
  }

  override fun powerOn() {
    log.debug("lgTV power on.")
  }

  override fun powerOff() {
    log.debug("lgTV power off.")
  }

  override fun volumeUp() {
    log.debug("lgTV volume up.")
  }

  override fun volumeDown() {
    log.debug("lgTV volume down.")
  }
}