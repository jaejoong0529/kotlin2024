package kr.mjc.rachel.jdbc.user;

import kr.mjc.rachel.jdbc.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetUserSequence {
  public static void main(String[] args) {
    System.out.println("Get - id ?");
    Scanner scanner = new Scanner(System.in);
    int id = scanner.nextInt();
    scanner.close();
    final String sql =
        "select id, username, password, first_name, date_joined from user where id=?";
    // dataSource를 구한다.
    DataSource dataSource = DataSourceFactory.getDataSource();
    Connection conn = null;
    PreparedStatement ps = null;
    try {
      // 1. dataSource에서 connection을 가져온다.
      conn = dataSource.getConnection();
      // 2. connection에서 preparedStatement를 만든다.
      ps = conn.prepareStatement(sql);
      ps.setInt(1, id);
      // 3. preparedStatement를 실행해서 resultSet를 리턴한다.
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        // Object - Relational Mapping. 데이터베이스 행으로 오브젝트 만들기
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("first_name"));
        user.setDateJoined(rs.getTimestamp("date_joined").toLocalDateTime());
        System.out.println(user);
      } else {
        System.out.println("사용자 없음");
      }
      rs.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      // preparedStatement 닫기
      if (ps != null)
        try {
          ps.close();
        } catch (SQLException e) {
          System.err.println(e.getMessage());
        }

      // connection 닫기
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException e) {
          System.err.println(e.getMessage());
        }
    }
  }
}
