package kr.mjc.rachel.jdbc.user;

import kr.mjc.rachel.jdbc.DataSourceFactory;
import kr.mjc.rachel.jdbc.Page;
import kr.mjc.rachel.jdbc.user.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUsers {
  public static void main(String[] args) {
    System.out.println("List - pageNumber pageSize ? ");
    Scanner scanner = new Scanner(System.in);
    Page page = new Page(scanner.nextInt(), scanner.nextInt());
    scanner.close();

    final String sql =
        "select id, username, first_name, date_joined from user order by id desc limit ?,?";
    List<User> userList = new ArrayList<>();

    DataSource dataSource = DataSourceFactory.getDataSource();
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setInt(1, page.offset());
      ps.setInt(2, page.size());

      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        // Object - Relational Mapping. 데이터베이스 행으로 오브젝트 만들기
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("first_name"));
        user.setDateJoined(rs.getTimestamp("date_joined").toLocalDateTime());
        userList.add(user);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println(userList);
  }
}
