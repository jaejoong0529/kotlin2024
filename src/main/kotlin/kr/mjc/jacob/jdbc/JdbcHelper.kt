package kr.mjc.jacob.jdbc

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import javax.sql.DataSource

/**
 * JDBC helper utilities
 * @author Jacob
 */
class JdbcHelper(val ds: DataSource) {

  /**
   * 목록을 가져오는 helper method
   * @return 결과 리스트. 결과가 없을 경우 빈 리스트
   */
  inline fun <T> list(sql: String, params: Array<*>?,
                      mapRow: (ResultSet) -> T): List<T> {
    ds.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        setParameters(ps, params)
        val list = mutableListOf<T>()
        val rs = ps.executeQuery()
        while (rs.next()) list.add(mapRow(rs))
        return list
      }
    }
  }

  /**
   * 한 건을 가져오는 helper method
   * @return 한 건 오브젝트. 결과가 없을 경우 NoResultException
   */
  inline fun <T> get(sql: String, params: Array<Any>?,
                     mapRow: (ResultSet) -> T): T {
    ds.connection.use { conn ->
      conn.prepareStatement(sql).use { ps ->
        setParameters(ps, params)
        val rs = ps.executeQuery()
        return if (rs.next()) mapRow(rs) else throw NoResultException()
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
        setParameters(ps, params)
        return ps.executeUpdate()
      }
    }
  }

  /**
   * preparedStatement에 파라미터를 설정한다.
   */
  fun setParameters(ps: PreparedStatement, params: Array<*>?) =
    params?.forEachIndexed { i, param -> ps.setObject(i + 1, param) }

  /**
   * 쿼리 결과가 없을 때 던진다.
   */
  class NoResultException : SQLException()
}