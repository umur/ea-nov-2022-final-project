package project.digital_videos.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue moviesQueue(){
        return new Queue("movie_queue");
    }
    @Bean
    public Queue seriesQueue(){
        return new Queue("series_queue");
    }
    @Bean
    public Queue commentsQueue(){
        return new Queue("comments_queue");
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("message_exchange");
    }

   @Bean
    public Binding movieBinding(Queue moviesQueue,TopicExchange exchange){
        return BindingBuilder.bind(moviesQueue).to(exchange).with("movie_routingKey");
    }


    @Bean
    public Binding seriesBinding(Queue seriesQueue,TopicExchange exchange){
        return BindingBuilder.bind(seriesQueue).to(exchange).with("series_routingKey");
    }
    @Bean
    public Binding commentsBinding(Queue commentsQueue,TopicExchange exchange){
        return BindingBuilder.bind(commentsQueue).to(exchange).with("comment_routingKey");
    }
@Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template=new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
