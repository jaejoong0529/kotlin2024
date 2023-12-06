package kr.mjc.jacob.basics.jdbc.user

data class Limit(var count: Int = 10, var page: Int = 1) {
  val offset: Int
    get() = (page - 1) * count
}
