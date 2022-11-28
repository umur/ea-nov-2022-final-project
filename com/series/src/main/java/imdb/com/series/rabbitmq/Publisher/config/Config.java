package imdb.com.series.rabbitmq.Publisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue commentQueue() {
        return new Queue("comment-queue", true);
    }

    @Bean
    FanoutExchange commentExchange() {
        return new FanoutExchange("comment-exchange");
    }

    @Bean
    Binding commentQueueBinder(Queue commentQueue, FanoutExchange commentExchange) {
        return BindingBuilder.bind(commentQueue).to(commentExchange);
    }


    @Bean
    public Queue seriesQueue() {
        return new Queue("series-queue", true);
    }

    @Bean
    FanoutExchange seriesExchange() {
        return new FanoutExchange("series-exchange");
    }

    @Bean
    Binding seriesQueueBinder(Queue seriesQueue, FanoutExchange seriesExchange) {
        return BindingBuilder.bind(seriesQueue).to(seriesExchange);
    }
}