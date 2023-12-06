package kr.mjc.rachel.spring.ioc.javaconfig;

import kr.mjc.rachel.spring.ioc.beanfactory.LgTV;
import kr.mjc.rachel.spring.ioc.beanfactory.SamsungTV;
import kr.mjc.rachel.spring.ioc.beanfactory.TV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * p.51 applicationContext.xml을 Java-based configuration으로 수정
 */
@Configuration
public class AppConfig {

  /**
   * samsungTV 빈을 생성한다.
   */
  @Bean
  public TV samsungTV() {
    return new SamsungTV();
  }

  /**
   * lgTV 빈을 생성한다.
   */
  @Bean
  public TV lgTV() {
    return new LgTV();
  }
}
