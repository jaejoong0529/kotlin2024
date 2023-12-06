package kr.mjc.rachel.spring.jdbc.article;

import kr.mjc.rachel.basics.jdbc.article.Article;
import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class AddArticle {
  public static void main(String[] args) {
    Article article = new Article();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("title// : ");
    article.setTitle(scanner.next());
    System.out.print("content// : ");
    article.setContent(scanner.next());
    scanner.close();
    article.setUserId(91); // 자신의 userId
    article.setName("김다미"); // 자신의 이름

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);

    articleDao.addArticle(article);
    log.info("저장 완료");
  }
}
