package kr.mjc.rachel.basics.jdbc.movie;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListMovies {
  public static void main(String[] args) {
    System.out.print("count page : ");
    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    int page = scanner.nextInt();
    scanner.close();

    MovieDao movieDao = new MovieDaoUsingJdbcHelper();
    List<Movie> movieList = movieDao.listMovies(count, page);
    log.debug(movieList.toString());
  }
}
