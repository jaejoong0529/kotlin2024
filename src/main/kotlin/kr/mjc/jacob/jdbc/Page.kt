package kr.mjc.jacob.jdbc

/**
 * 0 페이지부터 시작
 */
data class Page(val number: Int = 0, val size: Int = 10) {
  val offset: Int
    get() = number * size
}
