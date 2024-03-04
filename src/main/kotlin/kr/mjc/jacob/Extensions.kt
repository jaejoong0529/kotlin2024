package kr.mjc.jacob

import kotlin.reflect.full.memberProperties

/**
 * 오브젝트의 속성들을 맵으로 만드는 extension
 */
val Any.map: Map<String, Any?>
  get() = this::class.memberProperties.associate { prop ->
    prop.name to prop.getter.call(this)
  }