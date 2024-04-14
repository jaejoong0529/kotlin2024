package kr.mjc.jacob

import org.mindrot.jbcrypt.BCrypt
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.reflect.full.memberProperties

/**
 * 오브젝트의 속성들을 맵으로 만든다.
 */
val Any.toMap: Map<String, Any?>
  get() = this::class.memberProperties.associate { prop ->
    prop.name to prop.getter.call(this)
  }

/**
 * 문자열을 bcrypt hash 한다.
 */
val String.bcryptHashed: String get() = BCrypt.hashpw(this, BCrypt.gensalt())

/**
 * 날짜를 "yyyy-MM-dd HH:mm:ss"로 포맷하는 formatter
 */
val formatter: DateTimeFormatter =
  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

/**
 * 날짜를 formatter로 포맷한다.
 */
val LocalDateTime.formatted: String get() = this.format(formatter)
