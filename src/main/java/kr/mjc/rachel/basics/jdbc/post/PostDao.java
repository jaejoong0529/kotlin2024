package kr.mjc.rachel.basics.jdbc.post;

import java.util.List;

public interface PostDao {

  List<Post> listPosts(int count, int page);

  Post getPost(int postId);

  void addPost(Post post);

  int updatePost(Post post);

  int deletePost(int postId, int userId);
}
