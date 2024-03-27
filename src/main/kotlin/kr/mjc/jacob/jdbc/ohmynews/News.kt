package kr.mjc.jacob.jdbc.ohmynews

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class News(var rss: Rss) {

  data class Rss(var channel: Channel)

  data class Channel(var item: List<Item>)

  data class Item(var title: String, var description: String,
                  var pubDate: String) {
    val pubDateParsed
      get() = LocalDateTime.parse(pubDate, DateTimeFormatter.ISO_DATE_TIME)
  }
}