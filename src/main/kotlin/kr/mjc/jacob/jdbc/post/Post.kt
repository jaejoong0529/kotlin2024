package kr.mjc.jacob.jdbc.post

import kr.mjc.jacob.formatted
import java.time.LocalDateTime

class Post(var id: Int = 0, var title: String = "", var content: String = "",
           var userId: Int = 0, var firstName: String = "",
           var pubDate: LocalDateTime = LocalDateTime.now(),
           var lastModified: LocalDateTime = pubDate) {

  override fun toString(): String {
    return "Post(id=$id, title='$title', content='$content', userId=$userId, firstName='$firstName', pubDate=${pubDate.formatted}, lastModified=${lastModified.formatted})"
  }
}