package kr.mjc.rachel.spring.jdbc.user;

import kr.mjc.rachel.basics.jdbc.user.User;
import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Scanner;

/**
 * userId로 회원정보를 가져온다.
 */
@Slf4j
public class GetUser {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Get - userId : ");
    int userId = scanner.nextInt();
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = applicationContext.getBean(UserDao.class);

    try {
      User user = userDao.getUser(userId);
      log.info(user.toString());
    } catch (DataAccessException e) { // 데이터 없을 경우
      log.error("회원 없음");
    }
  }
}
