package kr.mjc.jacob.basics.collections

/**
 * Student Set 테스트
 */
fun main() {
  val s1 = Student(1, "Rachel")
  val s2 = Student(2, "David")
  val s3 = Student(1, "Rachel")

  println("%x".format(s1.hashCode()))
  println("%x".format(s2.hashCode()))
  println("%x".format(s3.hashCode()))

  val set1 = setOf(s1, s2, s3)
  println(set1)
}
