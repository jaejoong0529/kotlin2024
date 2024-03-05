package kr.mjc.jacob.jdbc.post.ohmynews

import com.google.gson.Gson
import kr.mjc.jacob.jdbc.JdbcHelper
import kr.mjc.jacob.jdbc.PostdbDataSource
import org.json.XML
import java.io.InputStreamReader
import java.net.URI

/**
 * 오마이 뉴스 저장
 */
class PostInserter {

  companion object {
    private val jdbcHelper = JdbcHelper(PostdbDataSource)
    private const val INSERT_POST =
      "insert post(title, content, user_id, first_name, pub_date) values(?,?,?,?,?)"
  }

  fun saveRss(rss: String) {
    val ohmynews = URI.create(rss).toURL()
    val jsonObj = XML.toJSONObject(InputStreamReader(ohmynews.openStream()))
    val replaceMap =
      mapOf("&nbsp;" to " ", "&lt;" to "<", "&gt;" to ">", "\\n" to "",
          "<br>" to "\n", "\\\\&quot;" to "", "<br />" to "\n",
          "&quot;" to "\\\"", "&amp;" to "&", "&middot;" to "·", "&#39;" to "'")
    val jsonStr = replaceMap.entries.fold(jsonObj.toString()) { acc, entry ->
      acc.replace(entry.key, entry.value)
    }
    val news = Gson().fromJson(jsonStr, News::class.java)
    var count = 0
    news.rss.channel.item.forEach { item ->
      jdbcHelper.update(INSERT_POST, item.title, item.description, 1, "Jacob",
          item.pubDateParsed)
      count++
    }
    println("$count 건 입력 완료")
  }
}

fun main() {
  val rss = arrayOf("https://rss.ohmynews.com/rss/ohmynews.xml",  // 전체기사
      "https://rss.ohmynews.com/rss/top.xml")                     // 주요기사
  val postInserter = PostInserter()
  rss.forEach { postInserter.saveRss(it) }
}
