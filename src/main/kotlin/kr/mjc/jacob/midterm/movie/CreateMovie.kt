package kr.mjc.jacob.midterm.movie

import kr.mjc.jacob.midterm.applicationContext
import java.util.*

fun main() {
  val movieRepository = applicationContext.getBean(MovieRepository::class.java)

  val movie: Movie = Scanner(System.`in`).use {
    Movie().apply {
      print("title ? ")
      title = it.nextLine()
      print("director ? ")
      director = it.nextLine()
    }
  }

  movieRepository.save(movie)
  println(movie)
}