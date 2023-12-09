package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DaoFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListPosts {
  public static void main(String[] args) {
    PostDao postDao = DaoFactory.getPostDao();
    Scanner scanner = new Scanner(System.in);
    System.out.print("count page : ");
    int count = scanner.nextInt();
    int page = scanner.nextInt();
    scanner.close();

    List<Post> postList = postDao.listPosts(count, page);
    log.debug(postList.toString());
  }
}
