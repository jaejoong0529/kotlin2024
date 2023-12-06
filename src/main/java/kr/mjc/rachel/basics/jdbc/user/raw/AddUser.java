package kr.mjc.rachel.basics.jdbc.user.raw;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

/**
 * 회원 가입
 */
@Slf4j
public class AddUser {

  public static void main(String[] args) {
    DataSource dataSource = DataSourceFactory.getDataSource();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Insert - email password name : ");
    // 입력
    String[] params = {scanner.next(), scanner.next(), scanner.next()};
    scanner.close();

    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(
            "insert user(email, password, name) values(?,sha2(?,256),?)",
            Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, params[0]);
      ps.setString(2, params[1]);
      ps.setString(3, params[2]);
      ps.executeUpdate();
      // 자동 생성 키 가져오기
      ResultSet keys = ps.getGeneratedKeys();
      if (keys.next())
        log.debug("저장 성공. userId={}", keys.getInt(1));
    } catch (SQLException e) {
      log.error(e.toString());
    }
  }
}
