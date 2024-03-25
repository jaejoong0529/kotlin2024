package kr.mjc.jacob.jdbc.post

import java.time.LocalDateTime

data class Post(var id: Int = 0, var title: String = "",
                var content: String = "", var userId: Int = 0,
                var firstName: String = "",
                var pubDate: LocalDateTime = LocalDateTime.now(),
                var lastModified: LocalDateTime = LocalDateTime.now())