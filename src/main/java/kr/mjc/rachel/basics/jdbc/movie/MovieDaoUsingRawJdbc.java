package kr.mjc.rachel.basics.jdbc.movie;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoUsingRawJdbc implements MovieDao {

  private static final String LIST_MOVIES =
      "select movieId, title, director from movie order by movieId desc limit ?, ?";
  private static final String ADD_MOVIE =
      "insert movie(title, director) values(?,?)";

  private final DataSource dataSource;

  public MovieDaoUsingRawJdbc() {
    this.dataSource = DataSourceFactory.getDataSource();
  }

  @Override
  public List<Movie> listMovies(int count, int page) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(LIST_MOVIES)) {
      ps.setInt(1, count * (page - 1));
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();
      List<Movie> movieList = new ArrayList<>();
      while (rs.next()) {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movieId"));
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movieList.add(movie);
      }
      return movieList;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void addMovie(Movie movie) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(ADD_MOVIE)) {
      ps.setString(1, movie.getTitle());
      ps.setString(2, movie.getDirector());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
