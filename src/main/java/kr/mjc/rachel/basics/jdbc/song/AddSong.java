package kr.mjc.rachel.basics.jdbc.song;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AddSong {
  public static void main(String[] args) {
    System.out.print("title//name//");
    Scanner scanner = new Scanner(System.in).useDelimiter("//");
    String title = scanner.next();
    String name = scanner.next();
    scanner.close();

    SongDao songDao = new SongDaoUsingJdbcHelper();
    Song song = new Song();
    song.setTitle(title);
    song.setName(name);
    songDao.addSong(song);
    log.debug("입력했습니다. {}", song);
  }
}
