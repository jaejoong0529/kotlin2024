package kr.mjc.jacob.springjdbc.post

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.post.Post
import kr.mjc.jacob.jdbc.post.PostDao

class PostDaoImpl : PostDao {
  override fun list(page: Page): List<Post> {
    TODO("Not yet implemented")
  }

  override fun getById(id: Int): Post? {
    TODO("Not yet implemented")
  }

  override fun create(post: Post): Int {
    TODO("Not yet implemented")
  }

  override fun update(post: Post): Int {
    TODO("Not yet implemented")
  }

  override fun deleteById(id: Int): Int {
    TODO("Not yet implemented")
  }
}
