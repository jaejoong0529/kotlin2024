package kr.mjc.jacob.midterm

import jakarta.persistence.EntityManagerFactory
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy
import org.mariadb.jdbc.MariaDbDataSource
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@ComponentScan
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
open class MidtermConfig(private val env: Environment) {

  @Bean
  open fun dataSource() = MariaDbDataSource(env.getProperty("db.url"))

  @Bean
  open fun namedParameterJdbcTemplate() =
    NamedParameterJdbcTemplate(dataSource())

  @Bean
  open fun entityManagerFactory() =
    LocalContainerEntityManagerFactoryBean().apply {
      dataSource = dataSource()
      setPackagesToScan("kr.mjc.jacob.midterm")
      jpaVendorAdapter = HibernateJpaVendorAdapter()
      // 엔티티의 프라퍼티와 테이블의 컬럼을 매핑하는 방법
      jpaPropertyMap["hibernate.physical_naming_strategy"] =
        CamelCaseToUnderscoresNamingStrategy::class.java
    }

  @Bean
  open fun transactionManager(
      entityManagerFactory: EntityManagerFactory): PlatformTransactionManager =
    JpaTransactionManager(entityManagerFactory)
}

val applicationContext =
  AnnotationConfigApplicationContext(MidtermConfig::class.java)

fun main() {
  applicationContext.beanDefinitionNames.forEach(::println)
}