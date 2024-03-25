package kr.mjc.jacob.jdbc.drivers

class DataSourceFactory {
  companion object {
    val instance: DataSource = MysqlDataSource()
  }
}

fun main() {
  val dataSource: DataSource = DataSourceFactory.instance
  dataSource.getConnection().use { conn ->
    conn.prepareStatement("...").use { ps ->
      ps.executeQuery()
    }
  }
}