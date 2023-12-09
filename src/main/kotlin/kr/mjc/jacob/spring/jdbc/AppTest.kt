package kr.mjc.jacob.spring.jdbc

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AppTest {
  fun <T> test(clazz: Class<T>, accept: (T, Logger) -> Unit) {
    val log = LoggerFactory.getLogger(object {}.javaClass.enclosingClass)
    val context = AnnotationConfigApplicationContext(AppConfig::class.java)
    val dao: T = context.getBean(clazz)
    accept(dao, log)
  }
}