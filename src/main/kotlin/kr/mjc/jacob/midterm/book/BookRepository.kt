package kr.mjc.jacob.midterm.book

import org.springframework.data.domain.Pageable
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

interface BookRepository : Repository<Book, Int> {

  @Transactional(readOnly = true)
  fun findAll(pageable: Pageable): List<Book>
}
