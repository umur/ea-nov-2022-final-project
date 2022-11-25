package imdb.com.movies.rabbitmq.Publisher.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;
    final private Queue commentQueue;
    public void sendCommentMessage(String message) {
        rabbitTemplate.convertAndSend(commentQueue.getName(), message);
    }

}
