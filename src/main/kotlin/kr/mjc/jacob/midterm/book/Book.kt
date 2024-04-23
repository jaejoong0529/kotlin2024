package kr.mjc.jacob.midterm.book

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  lateinit var title: String
  lateinit var author: String

  override fun toString(): String {
    return "Movie(id=$id, title='$title', director='$author')"
  }
}
