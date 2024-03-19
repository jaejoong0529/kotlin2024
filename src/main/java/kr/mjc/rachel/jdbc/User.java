package kr.mjc.rachel.jdbc;

import lombok.Data;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class User {
  int id;
  String username;
  String password;
  String firstName;
  LocalDateTime dateJoined;

  private DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public User hashPassword() {
    this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    return this;
  }

  @Override
  public String toString() {
    return String.format(
        "User{id=%d, username='%s', firstName='%s', dateJoined=%s}", id,
        username, firstName, dateJoined.format(formatter));
  }
}