package kr.mjc.rachel.basics.jdbc.movie;

import lombok.Data;

@Data
public class Movie {
  int movieId;
  String title;
  String director;

  @Override
  public String toString() {
    return String.format("\nMovie{movieId=%d, title=%s, director=%s}", movieId,
        title, director);
  }
}
