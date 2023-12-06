package kr.mjc.jacob.basics.jdbc

import org.mariadb.jdbc.MariaDbDataSource
import java.util.*

object Web2DataSource : MariaDbDataSource() {
  init {
    Properties().apply {
      load(Web2DataSource.javaClass.getResourceAsStream("/db.properties"))
      url = getProperty("url")
    }
  }
}