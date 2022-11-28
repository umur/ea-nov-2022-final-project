package project.series_service.configuration;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.series_service.service.SerieService;

@Component
public class MessageListener {
    @Autowired
    private SerieService serieService;


    @RabbitListener(queues = "series_queue")
    public void listener (long digitalVideoId){
        serieService.deleteSerie(digitalVideoId);
    }
}
