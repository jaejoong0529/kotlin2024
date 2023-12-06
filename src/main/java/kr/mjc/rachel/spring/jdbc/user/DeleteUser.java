package kr.mjc.rachel.spring.jdbc.user;

import kr.mjc.rachel.basics.jdbc.user.dao.UserDao;
import kr.mjc.rachel.spring.jdbc.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * userId와 password로 회원 삭제
 */
@Slf4j
public class DeleteUser {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Delete - userId password : ");
    int userId = scanner.nextInt();
    String password = scanner.next();
    scanner.close();

    ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(AppConfig.class);
    UserDao userDao = applicationContext.getBean(UserDao.class);

    int updatedRows = userDao.deleteUser(userId, password);
    if (updatedRows >= 1)
      log.info("삭제 완료");
    else
      log.info("삭제 실패"); // 회원번호가 없거나 비밀번호 틀림
  }
}
