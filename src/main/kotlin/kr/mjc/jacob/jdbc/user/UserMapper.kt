package kr.mjc.jacob.jdbc.user

import kr.mjc.jacob.getDatetime
import kr.mjc.jacob.getValue
import java.sql.ResultSet

fun mapUser(rs: ResultSet) =
  User(id = rs.getInt("id"), username = rs.getString("username"),
      password = rs.getValue("password", ""),
      firstName = rs.getString("first_name"),
      dateJoined = rs.getDatetime("date_joined"))