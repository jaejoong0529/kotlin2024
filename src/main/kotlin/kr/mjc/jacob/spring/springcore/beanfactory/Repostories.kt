package kr.mjc.jacob.spring.springcore.beanfactory

class UserDao {
  init {
    println("userDao created.")
  }

  fun listUsers() {
    println("list users.")
  }
}

class PostDao {
  init {
    println("postDao created.")
  }

  fun listPosts() {
    println("list posts.")
  }
}


