package kr.mjc.jacob.spring.jpa.post

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PostRepository : JpaRepository<Post, Long> {

  @Modifying
  @Transactional
  @Query("update Post set title=:title, content=:content where id=:id")
  fun update(id: Long, title: String, content: String): Int
}