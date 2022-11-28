package imdb.com.comment.Repository;


import imdb.com.comment.Entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {


    List<Comment> findAll();
    void deleteById(Integer id);

    @Query(value = "select c from Comment c where c.userid=?1")
    List<Comment> findCommentUserId(Integer userId);
}
