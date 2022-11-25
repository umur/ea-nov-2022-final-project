package imdb.com.comment.Service;


import imdb.com.comment.Entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAllComment();
    void deleteCommentById(Integer id);

}
