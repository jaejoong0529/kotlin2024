package kr.mjc.jacob.spring.di.javaconfig

import kr.mjc.jacob.spring.ioc.beanfactory.TV
import org.slf4j.LoggerFactory

/**
 * p.43 LgTV.java
 */
class LgTV(var speaker: Speaker? = null) : TV {

  private val log = LoggerFactory.getLogger(this.javaClass)

  override fun powerOn() {
    log.debug("lgTV power on.")
  }

  override fun powerOff() {
    log.debug("lgTV power off.")
  }

  override fun volumeUp() {
    speaker?.volumeUp()
  }

  override fun volumeDown() {
    speaker?.volumeDown()
  }
}