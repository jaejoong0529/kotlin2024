package kr.mjc.rachel.basics.jdbc.song;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

@Slf4j
public class ListSongs {
  public static void main(String[] args) {
    System.out.print("count page : ");
    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    int page = scanner.nextInt();
    scanner.close();

    SongDao songDao = new SongDaoUsingJdbcHelper();
    List<Song> songList = songDao.listSongs(count, page);
    log.debug(songList.toString());
  }
}
