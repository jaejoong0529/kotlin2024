package kr.mjc.jacob.jdbc.post

import kr.mjc.jacob.jdbc.Page

interface PostDao {
  fun list(page: Page): List<Post>

  fun getById(id: Int): Post?

  fun create(post: Post): Post

  fun update(post: Post): Int

  fun deleteById(id: Int): Int
}