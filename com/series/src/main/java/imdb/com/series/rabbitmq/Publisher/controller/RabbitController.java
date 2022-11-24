package imdb.com.series.rabbitmq.Publisher.controller;

import imdb.com.series.rabbitmq.Publisher.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/")
public class RabbitController {
    final private RabbitService rabbitService;

}
