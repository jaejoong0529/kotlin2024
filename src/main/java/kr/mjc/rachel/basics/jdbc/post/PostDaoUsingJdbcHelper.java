package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;
import kr.mjc.rachel.basics.jdbc.JdbcHelper;

import javax.sql.DataSource;
import java.util.List;

public class PostDaoUsingJdbcHelper implements PostDao {

  private static final String LIST_ARTICLES = """
      select postId, title, userId, name, cdate, udate from post
      order by postId desc limit ?,?
      """;

  private static final String GET_ARTICLE = """
      select postId, title, content, userId, name, cdate, udate from post
      where postId=?
      """;

  private static final String ADD_ARTICLE =
      "insert post(title, content, userId, name) values (?,?,?,?)";

  private static final String UPDATE_ARTICLE =
      "update post set title=?, content=? where postId=? and userId=?";

  private static final String DELETE_ARTICLE =
      "delete from post where postId=? and userId=?";

  private final JdbcHelper jdbcHelper;

  public PostDaoUsingJdbcHelper() {
    DataSource dataSource = DataSourceFactory.getDataSource();
    jdbcHelper = new JdbcHelper(dataSource);
  }

  @Override
  public List<Post> listPosts(int count, int page) {
    int offset = (page - 1) * count;
    return jdbcHelper.list(LIST_ARTICLES, rs -> {
      Post post = new Post();
      post.setPostId(rs.getInt("postId"));
      post.setTitle(rs.getString("title"));
      post.setUserId(rs.getInt("userId"));
      post.setName(rs.getString("name"));
      post.setCdate(rs.getString("cdate"));
      post.setUdate(rs.getString("udate"));
      return post;
    }, offset, count);
  }

  @Override
  public Post getPost(int postId) {
    return jdbcHelper.get(GET_ARTICLE, rs -> {
      Post post = new Post();
      post.setPostId(rs.getInt("postId"));
      post.setTitle(rs.getString("title"));
      post.setContent(rs.getString("content"));
      post.setUserId(rs.getInt("userId"));
      post.setName(rs.getString("name"));
      post.setCdate(rs.getString("cdate"));
      post.setUdate(rs.getString("udate"));
      return post;
    }, postId);
  }

  @Override
  public void addPost(Post post) {
    jdbcHelper.update(ADD_ARTICLE, post.getTitle(), post.getContent(),
        post.getUserId(), post.getName());
  }

  @Override
  public int updatePost(Post post) {
    return jdbcHelper.update(UPDATE_ARTICLE, post.getTitle(),
        post.getContent(), post.getPostId(), post.getUserId());
  }

  @Override
  public int deletePost(int postId, int userId) {
    return jdbcHelper.update(DELETE_ARTICLE, postId, userId);
  }
}
