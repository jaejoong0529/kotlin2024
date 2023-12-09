package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AddPost {
  public static void main(String[] args) {
    PostDao postDao = DaoFactory.getPostDao();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("title// : ");
    String title = scanner.next();
    System.out.print("content// : ");
    String content = scanner.next();
    scanner.close();

    Post post = new Post();
    post.setTitle(title);
    post.setContent(content);
    post.setUserId(1);
    post.setName("Jacob");
    postDao.addPost(post);

    log.debug("저장 완료");
  }
}
