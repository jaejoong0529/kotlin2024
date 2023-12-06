package kr.mjc.rachel.spring.jdbc.article;

import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class DeleteArticle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("articleId : ");
    int articleId = scanner.nextInt();
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);

    int userId = 91; // 자신의 userId
    int updatedRows = articleDao.deleteArticle(articleId, userId);
    if (updatedRows >= 1)
      log.info("삭제 완료");
    else
      log.info("해당 게시글이 없거나 작성자가 아님");
  }
}
