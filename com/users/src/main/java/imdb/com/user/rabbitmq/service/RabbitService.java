package imdb.com.user.rabbitmq.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;
    final private Queue moviesQueue;
    final private Queue seriesQueue;

    public void sendMoviessMessage(String message) {
        rabbitTemplate.convertAndSend(moviesQueue.getName(), message);
    }
    public void sendSeriesMessage(String message) {
        rabbitTemplate.convertAndSend(seriesQueue.getName(), message);
    }

}
