package kr.mjc.jacob.spring.di.javaconfig

import kr.mjc.jacob.spring.ioc.beanfactory.TV
import org.slf4j.LoggerFactory

class SamsungTV(val speaker: Speaker) : TV {

  private val log = LoggerFactory.getLogger(this.javaClass)

  override fun powerOn() {
    log.debug("samsungTV power on.")
  }

  override fun powerOff() {
    log.debug("samsungTV power off.")
  }

  override fun volumeUp() {
    speaker.volumeUp()
  }

  override fun volumeDown() {
    speaker.volumeDown()
  }
}