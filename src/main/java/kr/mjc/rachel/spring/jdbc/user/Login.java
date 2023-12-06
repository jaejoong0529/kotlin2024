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
 * 이메일과 비밀번호로 로그인 한다.
 */
@Slf4j
public class Login {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Login - email password : ");
    String[] params = {scanner.next(), scanner.next()};
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = applicationContext.getBean(UserDao.class);

    try {
      User user = userDao.login(params[0], params[1]);
      log.info(user.toString());
    } catch (DataAccessException e) { // 데이터 없을 경우
      log.error("로그인 실패");
    }
  }
}
