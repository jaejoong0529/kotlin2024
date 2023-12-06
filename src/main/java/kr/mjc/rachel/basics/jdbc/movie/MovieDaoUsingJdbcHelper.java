package kr.mjc.rachel.basics.jdbc.movie;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import kr.mjc.rachel.basics.jdbc.JdbcHelper;

import java.util.List;

public class MovieDaoUsingJdbcHelper implements MovieDao {

  private static final String LIST_MOVIES =
      "select movieId, title, director from movie order by movieId desc limit ?, ?";
  private static final String ADD_MOVIE =
      "insert movie(title, director) values(?,?)";

  private final JdbcHelper jdbcHelper;

  public MovieDaoUsingJdbcHelper() {
    this.jdbcHelper = new JdbcHelper(DataSourceFactory.getDataSource());
  }

  @Override
  public List<Movie> listMovies(int count, int page) {
    return jdbcHelper.list(LIST_MOVIES, rs -> {
      Movie movie = new Movie();
      movie.setMovieId(rs.getInt("movieId"));
      movie.setTitle(rs.getString("title"));
      movie.setDirector(rs.getString("director"));
      return movie;
    }, count * (page - 1), count);
  }

  @Override
  public void addMovie(Movie movie) {
    int key =
        jdbcHelper.insert(ADD_MOVIE, movie.getTitle(), movie.getDirector());
    movie.setMovieId(key);
  }
}