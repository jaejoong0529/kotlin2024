package kr.mjc.jacob.spring.jpa.post

import jakarta.persistence.*
import kr.mjc.jacob.formatted
import kr.mjc.jacob.spring.jpa.user.User
import java.time.LocalDateTime

@Entity
class Post {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long = 0
  lateinit var title: String
  lateinit var content: String
  @ManyToOne @JoinColumn(name = "user_id") lateinit var user: User
  lateinit var pubDate: LocalDateTime
  lateinit var lastModified: LocalDateTime

  override fun toString(): String =
    "Post(id=$id, title='$title', content='$content', pubDate=${pubDate.formatted}, lastModified=${lastModified.formatted}, user=$user)"
}