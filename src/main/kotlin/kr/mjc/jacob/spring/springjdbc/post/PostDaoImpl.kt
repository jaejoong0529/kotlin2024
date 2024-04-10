package kr.mjc.jacob.spring.springjdbc.post

import kr.mjc.jacob.jdbc.Page
import kr.mjc.jacob.jdbc.post.Post
import kr.mjc.jacob.jdbc.post.PostDao
import kr.mjc.jacob.toMap
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class PostDaoImpl(private val template: NamedParameterJdbcTemplate) : PostDao {

  companion object {
    private val CREATE = """
      insert post(title, content, user_id, first_name) 
      values(:title, :content, :userId, :firstName) returning *""".trimIndent()

    private val LIST = """
      select id, title, user_id, first_name, pub_date from post
      order by id desc limit :offset, :size""".trimIndent()

    private val GET_BY_ID = """
      select id, title, content, user_id, first_name, pub_date, last_modified
      from post where id=?""".trimIndent()

    private const val UPDATE =
      "update post set title=:title, content=:content where id=:id"

    private const val DELETE_BY_ID = "delete from post where id=?"
  }

  private val jdbcTemplate = template.jdbcTemplate

  private val rowMapper = BeanPropertyRowMapper(Post::class.java)

  override fun create(post: Post): Post =
    template.queryForObject(CREATE, post.toMap, rowMapper)!!

  override fun list(page: Page): List<Post> =
    template.query(LIST, page.toMap, rowMapper)

  override fun getById(id: Int): Post? =
    jdbcTemplate.queryForObject(GET_BY_ID, rowMapper, id)

  override fun update(post: Post): Int = template.update(UPDATE, post.toMap)

  override fun deleteById(id: Int): Int = jdbcTemplate.update(DELETE_BY_ID, id)
}
