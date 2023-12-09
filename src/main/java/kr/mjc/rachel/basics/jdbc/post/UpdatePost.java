package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class UpdatePost {
  public static void main(String[] args) {
    PostDao postDao = DaoFactory.getPostDao();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("postId// : ");
    int postId = scanner.nextInt();
    System.out.print("title// : ");
    String title = scanner.next();
    System.out.print("content// : ");
    String content = scanner.next();
    scanner.close();

    Post post = new Post();
    post.setPostId(postId);
    post.setTitle(title);
    post.setContent(content);
    post.setUserId(1);
    int updatedRows = postDao.updatePost(post);

    if (updatedRows >= 1)
      log.debug("수정 완료");
    else
      log.debug("해당 게시글이 없거나 작성자가 아님");
  }
}
