package kr.mjc.jacob.springcore.di.componentscan

import kr.mjc.jacob.springcore.ioc.beanfactory.TV
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class SamsungTV(@Qualifier("sonySpeaker") val speaker: Speaker) : TV {

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