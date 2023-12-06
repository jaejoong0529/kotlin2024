package kr.mjc.jacob.basics.jdbc

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement
import javax.sql.DataSource

/**
 * JDBC helper utilities
 * @author Jacob
 */
class JdbcHelper(private val ds: DataSource) {

  /**
   * 목록을 가져오는 helper method
   * @return 결과 리스트. 결과가 없을 경우 빈 리스트
   */
  fun <T> list(
    sql: String, vararg params: Any?, mapRow: (ResultSet) -> T
  ): List<T> {
    ds.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        setParameters(ps, *params)
        val list = mutableListOf<T>()
        val rs = ps.executeQuery()
        while (rs.next()) list.add(mapRow(rs))
        return list
      }
    }
  }

  /**
   * 한 건을 가져오는 helper method
   * @return 한 건 오브젝트. 결과가 없을 경우 null
   */
  fun <T> get(sql: String, vararg params: Any?, mapRow: (ResultSet) -> T): T? {
    ds.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        setParameters(ps, *params)
        val rs = ps.executeQuery()
        return if (rs.next()) mapRow(rs) else null
      }
    }
  }

  /**
   * 추가, 수정, 삭제하는 helper method
   * @return 변경된 행의 갯수
   */
  fun update(sql: String, vararg params: Any?): Int {
    ds.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        setParameters(ps, *params)
        return ps.executeUpdate()
      }
    }
  }

  /**
   * 추가하는 helper method. 자동 생성된 키를 리턴한다.
   * @return 자동생성된 키
   */
  fun insert(sql: String, vararg params: Any?): Int {
    ds.connection.use { conn ->
      conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).use { ps ->
        setParameters(ps, *params)
        ps.executeUpdate()
        val keys = ps.generatedKeys
        return if (keys.next()) keys.getInt(1) else 0
      }
    }
  }

  /**
   * preparedStatement에 파라미터를 설정한다.
   */
  private fun setParameters(ps: PreparedStatement, vararg params: Any?) {
    var i = 1
    params.forEach { param -> ps.setObject(i++, param) }
  }
}