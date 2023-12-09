package kr.mjc.rachel.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.BiConsumer;

@Slf4j
public class AppTest {
  public <T> void test(Class<T> clazz, BiConsumer<T, Logger> biConsumer) {
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);

    T dao = applicationContext.getBean(clazz);
    biConsumer.accept(dao, log);
  }
}