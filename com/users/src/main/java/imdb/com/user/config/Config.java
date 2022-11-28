package imdb.com.user.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Queue moviesQueue() {
        return new Queue("movies-queue", true);
    }

    @Bean
    FanoutExchange moviesExchange() {
        return new FanoutExchange("movies-exchange");
    }

    @Bean
    Binding moviesQueueBinder(Queue moviesQueue, FanoutExchange moviesExchange) {
        return BindingBuilder.bind(moviesQueue).to(moviesExchange);
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