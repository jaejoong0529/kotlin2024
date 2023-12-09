package kr.mjc.jacob.spring.ioc.beanfactory

/**
 * p.45 BeanFactory.java 수정
 */
class BeanFactory {
  private val map = mapOf("samsung" to SamsungTV(), "lg" to LgTV())

  fun getBean(name: String) = map[name]
}

