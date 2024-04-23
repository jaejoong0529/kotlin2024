package kr.mjc.jacob.midterm.movie

import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface MovieRepository : Repository<Movie, Int> {

  @Transactional
  fun save(movie: Movie)
}
