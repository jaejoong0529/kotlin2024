package kr.mjc.jacob.midterm.movie

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.toMap
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class MovieDao(private val template: NamedParameterJdbcTemplate) {

  companion object {
    private const val FIND_ALL =
      "select id, title, director from movie order by id desc limit :offset, :size"

    private val movieMapper = BeanPropertyRowMapper(Movie::class.java)
  }

  fun findAll(page: Page): List<Movie> =
    template.query(FIND_ALL, page.toMap, movieMapper)
}
