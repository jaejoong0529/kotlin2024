package kr.mjc.rachel.basics.jdbc.post;

import lombok.Data;

@Data
public class Post {
  int postId;
  String title;
  String content;
  int userId;
  String name;
  String cdate;
  String udate;

  @Override
  public String toString() {
    return String.format(
        "\nPost{postId=%d, title=%s, content=%s, userId=%d, name=%s, cdate=%s, udate=%s}",
        postId, title, content, userId, name, cdate, udate);
  }
}
