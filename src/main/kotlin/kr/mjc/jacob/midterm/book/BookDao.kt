package kr.mjc.jacob.midterm.book

import kr.mjc.jacob.toMap
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class BookDao(private val template: NamedParameterJdbcTemplate) {

  companion object {
    private const val SAVE =
      "insert book(title, author) values(:title, :author) returning id"
  }

  fun save(book: Book) {
    val id: Int? = template.queryForObject(SAVE, book.toMap, Int::class.java)
    book.id = id!!
  }
}
