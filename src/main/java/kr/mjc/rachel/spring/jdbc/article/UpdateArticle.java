package kr.mjc.rachel.spring.jdbc.article;

import kr.mjc.rachel.basics.jdbc.article.Article;
import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@Slf4j
public class UpdateArticle {
  public static void main(String[] args) {
    Article article = new Article();
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    System.out.print("articleId// : ");
    article.setArticleId(scanner.nextInt());
    System.out.print("title// : ");
    article.setTitle(scanner.next());
    System.out.print("content// : ");
    article.setContent(scanner.next());
    scanner.close();
    article.setUserId(91); // 자신의 userId

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    ArticleDao articleDao = applicationContext.getBean(ArticleDao.class);

    int updatedRows = articleDao.updateArticle(article);
    if (updatedRows >= 1)
      log.info("수정 완료");
    else
      log.info("해당 게시글이 없거나 작성자가 아님");
  }
}
