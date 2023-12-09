package kr.mjc.rachel.spring.jdbc.user;

import kr.mjc.rachel.basics.jdbc.user.User;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.spring.jdbc.AppTest;
import org.slf4j.Logger;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

/**
 * userId로 회원정보를 가져온다.
 */
public class GetUser {
  public static void main(String[] args) {
    new AppTest().test(UserDao.class, (UserDao userDao, Logger log) -> {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Get - userId : ");
      int userId = scanner.nextInt();
      scanner.close();
      try {
        User user = userDao.getUser(userId);
        log.info(user.toString());
      } catch (DataAccessException e) { // 데이터 없을 경우
        log.error("회원 없음");
      }
    });
  }
}
