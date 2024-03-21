package kr.mjc.jacob.spring.springdata

import org.mariadb.jdbc.MariaDbDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager

@Configuration
@EnableJdbcRepositories
@PropertySource("/application.properties")
open class SpringDataConfig(private val env: Environment) :
    AbstractJdbcConfiguration() {

  @Bean
  open fun dataSource() = MariaDbDataSource(env.getProperty("db.url"))

  @Bean
  open fun namedParameterJdbcOperations() =
    NamedParameterJdbcTemplate(dataSource())

  @Bean
  open fun transactionManager() = DataSourceTransactionManager(dataSource())
}