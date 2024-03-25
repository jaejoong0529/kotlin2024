package kr.mjc.jacob.spring.springcore.beanfactory

fun main() {
  val userDao = UserDao()
  userDao.listUsers()

  val postDao = PostDao()
  postDao.listPosts()
}

