package kr.mjc.rachel.spring.jdbc.post;

import kr.mjc.rachel.basics.jdbc.post.Post;
import kr.mjc.rachel.basics.jdbc.post.PostDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@Slf4j
public class ListPosts {
  public static void main(String[] args) {
    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    PostDao postDao = applicationContext.getBean(PostDao.class);

    List<Post> postList = postDao.listPosts(5, 1);
    log.info(postList.toString());
  }
}
