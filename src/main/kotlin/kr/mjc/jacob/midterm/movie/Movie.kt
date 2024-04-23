package kr.mjc.jacob.midterm.movie

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Movie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0
  lateinit var title: String
  lateinit var director: String

  override fun toString(): String {
    return "Movie(id=$id, title='$title', director='$director')"
  }
}
