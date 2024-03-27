package kr.mjc.jacob.jdbc.post

import kr.mjc.jacob.getDatetime
import kr.mjc.jacob.getValue
import java.sql.ResultSet

fun mapPost(rs: ResultSet) =
  Post(id = rs.getInt("id"), title = rs.getString("title"),
      content = rs.getValue("content", ""), userId = rs.getInt("user_id"),
      firstName = rs.getString("first_name"),
      pubDate = rs.getDatetime("pub_date"),
      lastModified = rs.getDatetime("last_modified"))
