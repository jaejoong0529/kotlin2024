package kr.mjc.rachel.basics.jdbc.movie;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AddMovie {
  public static void main(String[] args) {
    System.out.print("title//director//");
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    String title = scanner.next();
    String director = scanner.next();
    scanner.close();

    MovieDao movieDao = new MovieDaoUsingJdbcHelper();
    Movie movie = new Movie();
    movie.setTitle(title);
    movie.setDirector(director);
    movieDao.addMovie(movie);
    log.debug("입력했습니다. {}", movie);
  }
}
