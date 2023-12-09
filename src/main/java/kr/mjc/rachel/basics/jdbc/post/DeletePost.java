package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class DeletePost {
  public static void main(String[] args) {
    PostDao postDao = DaoFactory.getPostDao();
    Scanner scanner = new Scanner(System.in);
    System.out.print("postId : ");
    int postId = scanner.nextInt();
    scanner.close();

    int updatedRows = postDao.deletePost(postId, 1);
    if (updatedRows >= 1)
      log.debug("삭제 완료");
    else
      log.debug("해당 게시글이 없거나 작성자가 아님");
  }
}
