package project.comment_service.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.comment_service.service.CommentService;



@Component
public class MessageListener {
    @Autowired
    private CommentService commentService ;


    @RabbitListener(queues = "comments_queue")
    public void listener (long digitalVideoId){
        commentService.deleteComment(digitalVideoId);
    }
}
