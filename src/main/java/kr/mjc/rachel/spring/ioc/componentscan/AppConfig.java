package kr.mjc.rachel.spring.ioc.componentscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * p.51 applicationContext.xml을 Java-based configuration으로 수정
 */
@Configuration
@ComponentScan(basePackages = "kr.mjc.rachel.spring.ioc.componentscan")
public class AppConfig {
}
