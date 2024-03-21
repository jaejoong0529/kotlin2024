package kr.mjc.jacob

import org.mindrot.jbcrypt.BCrypt
import kotlin.reflect.full.memberProperties

/**
 * 오브젝트의 속성들을 맵으로 만드는 extension
 */
val Any.map: Map<String, Any?>
  get() = this::class.memberProperties.associate { prop ->
    prop.name to prop.getter.call(this)
  }

val String.bcryptHashed: String
  get() = BCrypt.hashpw(this, BCrypt.gensalt())
