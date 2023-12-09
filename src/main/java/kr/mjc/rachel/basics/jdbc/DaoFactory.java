package kr.mjc.rachel.basics.jdbc;

import kr.mjc.rachel.basics.jdbc.post.PostDao;
import kr.mjc.rachel.basics.jdbc.post.PostDaoUsingJdbcHelper;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDaoUsingJdbcHelper;

public class DaoFactory {

  public static UserDao getUserDao() {
    return new UserDaoUsingJdbcHelper();
  }

  public static PostDao getPostDao() {
    return new PostDaoUsingJdbcHelper();
  }
}
