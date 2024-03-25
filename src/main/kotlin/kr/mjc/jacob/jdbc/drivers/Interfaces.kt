package kr.mjc.jacob.jdbc.drivers

interface DataSource {
  fun getConnection(): Connection
}

interface Connection : AutoCloseable {
  fun prepareStatement(sql: String): Statement
}

interface Statement : AutoCloseable {
  fun executeQuery()
  fun executeUpdate()
}