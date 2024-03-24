package kr.mjc.jacob.jdbc

import org.mariadb.jdbc.MariaDbDataSource
import java.util.*
import javax.sql.DataSource

class DataSourceFactory {
  companion object {
    private val props = Properties().apply {
      load(DataSourceFactory::class.java.getResourceAsStream(
          "/application.properties"))
    }

    val dataSource: DataSource = MariaDbDataSource(props.getProperty("db.url"))
  }
}
