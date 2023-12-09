package kr.mjc.rachel.spring.jdbc.dao;

import kr.mjc.rachel.basics.jdbc.post.Post;
import kr.mjc.rachel.basics.jdbc.post.PostDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoUsingNamedParameterJdbcTemplate implements PostDao {

  private static final String LIST_ARTICLES = """
      select postId, title, userId, name, cdate, udate from post
      order by postId desc limit ?,?
      """;

  private static final String GET_ARTICLE = """
      select postId, title, content, userId, name, cdate, udate from post
      where postId=?
      """;

  private static final String ADD_ARTICLE = """
      insert post(title, content, userId, name)
      values (:title, :content, :userId, :name)
      """;

  private static final String UPDATE_ARTICLE = """
      update post set title=:title, content=:content
      where postId=:postId and userId=:userId
      """;

  private static final String DELETE_ARTICLE =
      "delete from post where postId=? and userId=?";

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public PostDaoUsingNamedParameterJdbcTemplate(
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    this.namedParameterJdbcTemplate =
        new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  /**
   * resultSet을 post 오브젝트로 자동 매핑하는 매퍼
   */
  private final RowMapper<Post> postRowMapper =
      new BeanPropertyRowMapper<>(Post.class);

  @Override
  public List<Post> listPosts(int count, int page) {
    int offset = (page - 1) * count;
    return jdbcTemplate.query(LIST_ARTICLES, postRowMapper, offset, count);
  }

  @Override
  public Post getPost(int postId) {
    return jdbcTemplate.queryForObject(GET_ARTICLE, postRowMapper,
        postId);
  }

  @Override
  public void addPost(Post post) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(post);
    namedParameterJdbcTemplate.update(ADD_ARTICLE, params);
  }

  @Override
  public int updatePost(Post post) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(post);
    return namedParameterJdbcTemplate.update(UPDATE_ARTICLE, params);
  }

  @Override
  public int deletePost(int postId, int userId) {
    return jdbcTemplate.update(DELETE_ARTICLE, postId, userId);
  }
}
