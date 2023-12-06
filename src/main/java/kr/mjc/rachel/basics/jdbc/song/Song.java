package kr.mjc.rachel.basics.jdbc.song;

import lombok.Data;

@Data
public class Song {
  int songId;
  String title;
  String name;

  @Override
  public String toString() {
    return String.format("\nSong{songId=%d, title=%s, name=%s}", songId, title,
        name);
  }
}
