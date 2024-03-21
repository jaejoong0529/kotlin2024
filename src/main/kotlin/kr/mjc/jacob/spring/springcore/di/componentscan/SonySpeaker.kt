package kr.mjc.jacob.springcore.di.componentscan

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class SonySpeaker : Speaker {

  private val log = LoggerFactory.getLogger(this.javaClass)

  override fun volumeUp() {
    log.debug("sony speaker volume up")
  }

  override fun volumeDown() {
    log.debug("sony speaker volume down")
  }
}