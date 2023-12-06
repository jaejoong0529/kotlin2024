package kr.mjc.rachel.basics.jdbc.movie;

import java.util.List;

public interface MovieDao {
  List<Movie> listMovies(int count, int page);

  void addMovie(Movie movie);
}