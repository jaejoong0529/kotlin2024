package kr.mjc.jacob.springcore.ioc.beanfactory

/**
 * p.45 BeanFactory.java 수정
 */
class BeanFactory {
  private val map = mapOf("samsung" to SamsungTV(), "lg" to LgTV())

  fun getBean(first_name: String) = map[first_name]
}

