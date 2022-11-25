package imdb.com.comment.Service;

import imdb.com.comment.Entity.Comment;
import imdb.com.comment.Repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }
}
