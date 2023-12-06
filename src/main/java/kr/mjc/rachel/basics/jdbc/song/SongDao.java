package kr.mjc.rachel.basics.jdbc.song;

import java.util.List;

public interface SongDao {
  List<Song> listSongs(int count, int page);

  void addSong(Song song);
}