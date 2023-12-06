package kr.mjc.rachel.basics.jdbc.song;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDaoUsingRawJdbc implements SongDao {

  private static final String LIST_MOVIES =
      "select songId, title, name from song order by songId desc limit ?, ?";
  private static final String ADD_MOVIE =
      "insert song(title, name) values(?,?)";

  private final DataSource dataSource;

  public SongDaoUsingRawJdbc() {
    this.dataSource = DataSourceFactory.getDataSource();
  }

  @Override
  public List<Song> listSongs(int count, int page) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(LIST_MOVIES)) {
      ps.setInt(1, count * (page - 1));
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();
      List<Song> songList = new ArrayList<>();
      while (rs.next()) {
        Song song = new Song();
        song.setSongId(rs.getInt("songId"));
        song.setTitle(rs.getString("title"));
        song.setName(rs.getString("name"));
        songList.add(song);
      }
      return songList;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void addSong(Song song) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(ADD_MOVIE)) {
      ps.setString(1, song.getTitle());
      ps.setString(2, song.getName());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
