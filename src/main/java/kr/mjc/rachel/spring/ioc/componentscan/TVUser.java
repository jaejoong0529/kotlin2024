package kr.mjc.rachel.spring.ioc.componentscan;

import kr.mjc.rachel.spring.ioc.beanfactory.TV;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * p.53 TVUser.java 수정
 */
@Slf4j
public class TVUser {
  public static void main(String[] args) {
    // AppConfig 클래스에서 구성한대로 빈을 구성한다.
    // 빈들을 보관한 영역을 applicationContext라 한다.
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
    log.info("빈 구성을 마쳤습니다.");

    // context에서 SamsungTV 타입의 빈을 꺼낸다.
    TV samsungTV = context.getBean(SamsungTV.class);
    samsungTV.powerOn();
    samsungTV.powerOff();

    // context에서 lgTV 이름의 빈을 꺼낸다.
    TV lgTV = (LgTV) context.getBean("lgTV");
    lgTV.powerOn();
    lgTV.powerOff();
  }
}
