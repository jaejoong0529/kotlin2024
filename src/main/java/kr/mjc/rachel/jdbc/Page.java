package kr.mjc.rachel.jdbc;

/**
 * 0 페이지부터 시작
 */
public record Page(int number, int size) {
  /**
   * 목록 시작 위치
   */
  public int offset() {
    return number * size;
  }
}
