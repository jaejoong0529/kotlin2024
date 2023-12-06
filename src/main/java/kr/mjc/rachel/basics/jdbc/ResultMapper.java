package kr.mjc.rachel.basics.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSet - Object 매핑을 위한 functional interface
 */
@FunctionalInterface
public interface ResultMapper<T> {
  T mapRow(ResultSet rs) throws SQLException;
}
