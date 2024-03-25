package kr.mjc.rachel.jdbc.user;

import kr.mjc.rachel.jdbc.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateUser {
  public static void main(String[] args) {
    System.out.println("Create - username(username) password first_name ? ");
    Scanner scanner = new Scanner(System.in);
    User user = new User();
    user.setUsername(scanner.next());
    user.setPassword(scanner.next());
    user.setFirstName(scanner.next());
    scanner.close();
    user.hashPassword();  // 패스워드 해시

    final String sql =
        "insert user(username, password, first_name) values(?, ?, ?)";
    DataSource dataSource = DataSourceFactory.getDataSource();
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getFirstName());
      ps.executeUpdate();
      System.out.println("저장 완료");
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }
  }
}
