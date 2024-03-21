package kr.mjc.jacob.spring.springcore.ioc.beanfactory

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