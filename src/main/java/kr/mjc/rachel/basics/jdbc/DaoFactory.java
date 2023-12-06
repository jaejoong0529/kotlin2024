package kr.mjc.rachel.basics.jdbc;

import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import kr.mjc.rachel.basics.jdbc.article.ArticleDaoUsingJdbcHelper;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDaoUsingJdbcHelper;

public class DaoFactory {

  public static UserDao getUserDao() {
    return new UserDaoUsingJdbcHelper();
  }

  public static ArticleDao getArticleDao() {
    return new ArticleDaoUsingJdbcHelper();
  }
}
