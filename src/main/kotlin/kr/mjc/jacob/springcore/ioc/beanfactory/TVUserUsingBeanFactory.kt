package kr.mjc.jacob.springcore.ioc.beanfactory

import org.slf4j.LoggerFactory

/**
 * p.45 TVUser.java 수정
 */
fun main() {
  val log = LoggerFactory.getLogger(object {}.javaClass.enclosingClass)

  // 빈들을 미리 생성해서 factory에 보관한다.
  val factory = BeanFactory()
  log.info("빈 구성을 마쳤습니다.")

  val samsungTV = factory.getBean("samsung") as TV
  samsungTV.powerOn()
  samsungTV.powerOff()

  val lgTV = factory.getBean("lg") as TV
  lgTV.powerOn()
  lgTV.powerOff()
}
