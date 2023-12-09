package kr.mjc.rachel.spring.jdbc.post;

import kr.mjc.rachel.basics.jdbc.post.Post;
import kr.mjc.rachel.basics.jdbc.post.PostDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

@Slf4j
public class GetPost {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("postId : ");
    int postId = scanner.nextInt();
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    PostDao postDao = applicationContext.getBean(PostDao.class);

    try {
      Post post = postDao.getPost(postId);
      log.info(post.toString());
    } catch (DataAccessException e) {
      log.error("해당 게시글 없음");
    }
  }
}
