package imdb.com.comment.Service;

import imdb.com.comment.Entity.Comment;
import imdb.com.comment.Repository.CommentRepository;
import imdb.com.comment.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private RabbitService rabbitService;
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }
    @RabbitListener(queues = {"comment-queue"})
    @Override
    public void deleteCommentByUserId(String id) {
        Integer userId= Integer.parseInt(id.split(" ")[1]);
        commentRepository.findCommentUserId(userId).forEach(comment -> {
            commentRepository.deleteById(comment.getId());
        });
    }

}
