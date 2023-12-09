package kr.mjc.rachel.spring.jdbc.post;

import kr.mjc.rachel.basics.jdbc.post.Post;
import kr.mjc.rachel.basics.jdbc.post.PostDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class UpdatePost {
  public static void main(String[] args) {
    Post post = new Post();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("postId// : ");
    post.setPostId(scanner.nextInt());
    System.out.print("title// : ");
    post.setTitle(scanner.next());
    System.out.print("content// : ");
    post.setContent(scanner.next());
    scanner.close();
    post.setUserId(91); // 자신의 userId

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    PostDao postDao = applicationContext.getBean(PostDao.class);

    int updatedRows = postDao.updatePost(post);
    if (updatedRows >= 1)
      log.info("수정 완료");
    else
      log.info("해당 게시글이 없거나 작성자가 아님");
  }
}
