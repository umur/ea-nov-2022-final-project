package project.movies_service.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.movies_service.service.MovieService;



@Component
public class MessageListener {
    @Autowired
    private MovieService movieService;


    @RabbitListener(queues = "movie_queue")
    public void listener (long digitalVideoId){
        movieService.deleteMovie(digitalVideoId);
    }
}
