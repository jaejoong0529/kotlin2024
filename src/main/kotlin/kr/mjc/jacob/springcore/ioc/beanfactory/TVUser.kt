package kr.mjc.jacob.springcore.ioc.beanfactory

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