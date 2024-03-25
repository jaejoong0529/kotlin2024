package kr.mjc.jacob.spring.springcore.di.javaconfig

import org.slf4j.LoggerFactory

class AppleSpeaker : Speaker {

  private val log = LoggerFactory.getLogger(this.javaClass)

  override fun volumeUp() {
    log.debug("apple speaker volume up")
  }

  override fun volumeDown() {
    log.debug("apple speaker volume down")
  }
}