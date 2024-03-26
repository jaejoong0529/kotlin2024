package kr.mjc.jacob.jdbc.drivers

class MysqlDataSource : DataSource {
  init {
    println("mysqlDataSource created.")
  }

  override fun getConnection(): Connection = MysqlConnection()
}

class MysqlConnection : Connection {
  init {
    println("mysqlConnection created.")
  }

  override fun prepareStatement(sql: String): Statement = MysqlStatement()

  override fun close() = println("mysqlConnection closed.")
}

class MysqlStatement : Statement {
  init {
    println("mysqlStatement created.")
  }

  override fun executeQuery() = println("mysql executeQuery()")

  override fun executeUpdate() = println("mysql executeUpdate()")

  override fun close() = println("mysqlStatement closed.")
}