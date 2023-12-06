package kr.mjc.rachel.spring.jdbc.article;

import kr.mjc.rachel.basics.jdbc.article.Article;
import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

@Slf4j
public class GetArticles {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("articleId : ");
    int articleId = scanner.nextInt();
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);

    try {
      Article article = articleDao.getArticle(articleId);
      log.info(article.toString());
    } catch (DataAccessException e) {
      log.error("해당 게시글 없음");
    }
  }
}
