package kr.mjc.rachel.spring.di.quiz;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import kr.mjc.rachel.basics.jdbc.JdbcHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * dataSource와 jdbcHelper는 여기서 @Bean으로 구성하고
 * userDao는 @ComponentScan과 @Component로 구성한다.
 */
@Configuration
@ComponentScan(basePackages = "kr.mjc.rachel.spring.di.quiz")
public class AppConfig {
  @Bean
  public DataSource dataSource() {
    return DataSourceFactory.getDataSource();
  }

  @Bean
  public JdbcHelper jdbcHelper(DataSource dataSource) {
    return new JdbcHelper(dataSource);
  }
}
