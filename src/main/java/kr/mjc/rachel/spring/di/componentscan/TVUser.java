package kr.mjc.rachel.spring.di.componentscan;

import kr.mjc.rachel.spring.ioc.beanfactory.TV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class TVUser {
  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    log.info("빈 구성을 마쳤습니다.");

    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.volumeUp();
    samsungTV.volumeDown();

    TV lgTV = context.getBean(LgTV.class);
    lgTV.volumeUp();
    lgTV.volumeDown();
  }
}
