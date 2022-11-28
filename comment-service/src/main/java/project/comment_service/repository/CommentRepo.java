package project.comment_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.comment_service.entity.Comment;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment,Long> {
    List<Comment> findAllByDigitalVideoId(long digitalVideoId);
    List<Comment> findAllByUserId(long userId);
}
