package kr.mjc.jacob.spring.jpa.post

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface PostRepository : JpaRepository<Post, Long> {

  @Modifying
  @Transactional
  @Query("update post set title=:title, content=:content where id=:id", nativeQuery=true)
  fun update(id: Long, title: String, content: String): Int
}
