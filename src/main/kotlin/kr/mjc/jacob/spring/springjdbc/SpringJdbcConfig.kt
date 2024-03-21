package kr.mjc.jacob.springjdbc

import org.mariadb.jdbc.MariaDbDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
open class SpringJdbcConfig(private val env: Environment) {
  @Bean
  open fun dataSource() = MariaDbDataSource(env.getProperty("db.url"))

  @Bean
  open fun nameParameterJdbcTemplate() =
    NamedParameterJdbcTemplate(dataSource())
}