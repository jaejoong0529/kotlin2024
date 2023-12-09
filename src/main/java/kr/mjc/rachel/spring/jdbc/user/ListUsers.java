package kr.mjc.rachel.spring.jdbc.user;

import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.spring.jdbc.AppTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListUsers {
  public static void main(String[] args) {
    new AppTest().test(UserDao.class, (userDao, log) -> {
      log.info(userDao.listUsers(5, 1).toString());
    });
  }
}
