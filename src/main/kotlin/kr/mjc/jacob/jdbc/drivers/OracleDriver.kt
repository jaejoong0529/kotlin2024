package kr.mjc.jacob.jdbc.drivers

class OracleDataSource : DataSource {
  init {
    println("oracleDataSource created.")
  }

  override fun getConnection(): Connection = OracleConnection()
}

class OracleConnection : Connection {
  init {
    println("oracleConnection created.")
  }

  override fun prepareStatement(sql: String): Statement = OracleStatement()

  override fun close() = println("oracleConnection closed")
}

class OracleStatement : Statement {
  init {
    println("oracleStatement created.")
  }

  override fun executeQuery() = println("oracle executeQuery()")

  override fun executeUpdate() = println("oracle executeUpdate()")

  override fun close() = println("oracleStatement closed.")
}