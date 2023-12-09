package kr.mjc.jacob.spring.ioc.beanfactory

/**
 * p.44 TVUser.java
 */
fun main() {
  SamsungTV().run {
    powerOn()
    powerOff()
  }

  LgTV().run {
    powerOn()
    powerOff()
  }
}