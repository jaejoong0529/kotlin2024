package kr.mjc.jacob.springcore.di.componentscan

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class AppleSpeaker : Speaker {

  private val log = LoggerFactory.getLogger(this.javaClass)

  override fun volumeUp() {
    log.debug("apple speaker volume up")
  }

  override fun volumeDown() {
    log.debug("apple speaker volume down")
  }
}