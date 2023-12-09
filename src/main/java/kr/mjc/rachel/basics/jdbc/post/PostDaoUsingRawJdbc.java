package kr.mjc.rachel.basics.jdbc.post;

import kr.mjc.rachel.basics.jdbc.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoUsingRawJdbc implements PostDao {

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

  private final DataSource dataSource;

  /**
   * default constructor
   */
  public PostDaoUsingRawJdbc() {
    dataSource = DataSourceFactory.getDataSource();
  }

  /**
   * 게시글 목록
   */
  @Override
  public List<Post> listPosts(int count, int page) {
    int offset = (page - 1) * count;
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(LIST_ARTICLES)) {
      ps.setInt(1, offset);
      ps.setInt(2, count);
      ResultSet rs = ps.executeQuery();
      List<Post> postList = new ArrayList<>();
      while (rs.next()) {
        Post post = new Post();
        post.setPostId(rs.getInt("postId"));
        post.setTitle(rs.getString("title"));
        post.setUserId(rs.getInt("userId"));
        post.setName(rs.getString("name"));
        post.setCdate(rs.getString("cdate"));
        post.setUdate(rs.getString("udate"));
        postList.add(post);
      }
      return postList;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 게시글 정보
   */
  @Override
  public Post getPost(int postId) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(GET_ARTICLE)) {
      ps.setInt(1, postId);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Post post = new Post();
        post.setPostId(rs.getInt("postId"));
        post.setTitle(rs.getString("title"));
        post.setTitle(rs.getString("content"));
        post.setUserId(rs.getInt("userId"));
        post.setName(rs.getString("name"));
        post.setCdate(rs.getString("cdate"));
        post.setUdate(rs.getString("udate"));
        return post;
      }
      return null;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 게시글 쓰기
   */
  @Override
  public void addPost(Post post) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(ADD_ARTICLE)) {
      ps.setString(1, post.getTitle());
      ps.setString(2, post.getContent());
      ps.setInt(3, post.getUserId());
      ps.setString(4, post.getName());
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 게시글 수정
   */
  @Override
  public int updatePost(Post post) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(UPDATE_ARTICLE)) {
      ps.setString(1, post.getTitle());
      ps.setString(2, post.getContent());
      ps.setInt(3, post.getPostId());
      ps.setInt(4, post.getUserId());
      return ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 게시글 삭제
   */
  @Override
  public int deletePost(int postId, int userId) {
    try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(DELETE_ARTICLE)) {
      ps.setInt(1, postId);
      ps.setInt(2, userId);
      return ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
