package kr.mjc.jacob.spring.jdbc

import org.mariadb.jdbc.MariaDbDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = ["kr.mjc.jacob.spring.jdbc.dao"])
@PropertySource("classpath:db.properties")
open class AppConfig {
  @Autowired lateinit var env: Environment

  @Bean
  open fun dataSource() = MariaDbDataSource(env.getProperty("url"))

  @Bean
  open fun jdbcTemplate(dataSource: DataSource) = JdbcTemplate(dataSource)

  @Bean
  open fun nameParameterJdbcTemplate(jdbcTemplate: JdbcTemplate) =
    NamedParameterJdbcTemplate(jdbcTemplate)
}