package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class GetPost {
  public static void main(String[] args) {
    PostDao postDao = DaoFactory.getPostDao();
    Scanner scanner = new Scanner(System.in);
    System.out.print("postId : ");
    int postId = scanner.nextInt();
    scanner.close();

    Post post = postDao.getPost(postId);
    if (post != null)
      log.debug(post.toString());
    else
      log.debug("해당 게시글 없음");
  }
}
