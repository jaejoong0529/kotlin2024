package kr.mjc.rachel.basics.jdbc.song;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import kr.mjc.rachel.basics.jdbc.JdbcHelper;

import java.util.List;

public class SongDaoUsingJdbcHelper implements SongDao {

  private static final String LIST_SONGS =
      "select songId, title, name from song order by songId desc limit ?, ?";
  private static final String ADD_SONG = "insert song(title, name) values(?,?)";

  private final JdbcHelper jdbcHelper;

  public SongDaoUsingJdbcHelper() {
    this.jdbcHelper = new JdbcHelper(DataSourceFactory.getDataSource());
  }

  @Override
  public List<Song> listSongs(int count, int page) {
    return jdbcHelper.list(LIST_SONGS, rs -> {
      Song song = new Song();
      song.setSongId(rs.getInt("songId"));
      song.setTitle(rs.getString("title"));
      song.setName(rs.getString("name"));
      return song;
    }, count * (page - 1), count);
  }

  @Override
  public void addSong(Song song) {
    int key = jdbcHelper.insert(ADD_SONG, song.getTitle(), song.getName());
    song.setSongId(key);
  }
}