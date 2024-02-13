package kr.mjc.jacob.basics.jdbc

import org.mariadb.jdbc.MariaDbDataSource
import java.util.*

object PostDbDataSource : MariaDbDataSource() {
  init {
    Properties().apply {
      load(PostDbDataSource.javaClass.getResourceAsStream("/db.properties"))
      url = getProperty("url")
    }
  }
}