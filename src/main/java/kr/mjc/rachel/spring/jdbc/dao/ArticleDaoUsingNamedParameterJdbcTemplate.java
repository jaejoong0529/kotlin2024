package kr.mjc.rachel.spring.jdbc.dao;

import kr.mjc.rachel.basics.jdbc.article.Article;
import kr.mjc.rachel.basics.jdbc.article.ArticleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDaoUsingNamedParameterJdbcTemplate implements ArticleDao {

  private static final String LIST_ARTICLES = """
      select articleId, title, userId, name, cdate, udate from article
      order by articleId desc limit ?,?
      """;

  private static final String GET_ARTICLE = """
      select articleId, title, content, userId, name, cdate, udate from article
      where articleId=?
      """;

  private static final String ADD_ARTICLE = """
      insert article(title, content, userId, name)
      values (:title, :content, :userId, :name)
      """;

  private static final String UPDATE_ARTICLE = """
      update article set title=:title, content=:content
      where articleId=:articleId and userId=:userId
      """;

  private static final String DELETE_ARTICLE =
      "delete from article where articleId=? and userId=?";

  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public ArticleDaoUsingNamedParameterJdbcTemplate(
      NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
    this.namedParameterJdbcTemplate =
        new NamedParameterJdbcTemplate(jdbcTemplate);
  }

  /**
   * resultSet을 article 오브젝트로 자동 매핑하는 매퍼
   */
  private final RowMapper<Article> articleRowMapper =
      new BeanPropertyRowMapper<>(Article.class);

  @Override
  public List<Article> listArticles(int count, int page) {
    int offset = (page - 1) * count;
    return jdbcTemplate.query(LIST_ARTICLES, articleRowMapper, offset, count);
  }

  @Override
  public Article getArticle(int articleId) {
    return jdbcTemplate.queryForObject(GET_ARTICLE, articleRowMapper,
        articleId);
  }

  @Override
  public void addArticle(Article article) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(article);
    namedParameterJdbcTemplate.update(ADD_ARTICLE, params);
  }

  @Override
  public int updateArticle(Article article) {
    SqlParameterSource params = new BeanPropertySqlParameterSource(article);
    return namedParameterJdbcTemplate.update(UPDATE_ARTICLE, params);
  }

  @Override
  public int deleteArticle(int articleId, int userId) {
    return jdbcTemplate.update(DELETE_ARTICLE, articleId, userId);
  }
}
