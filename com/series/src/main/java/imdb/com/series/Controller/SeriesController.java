package imdb.com.series.Controller;

import imdb.com.series.Entity.Favourite;
import imdb.com.series.Entity.Series;
import imdb.com.series.Service.SeriesServiceImpl;
import imdb.com.series.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SeriesController {

    private SeriesServiceImpl seriesService;

    private RabbitService rabbitService;

    @GetMapping
    public List<Series> findAllSeries() {
        return seriesService.findAllSeries();
    }

    @GetMapping("/favourites/{userId}")
    public List<Series> findAllSeriesByUserId(@PathVariable int userId){
        return seriesService.findFavouriteSeriesByUserId(userId);
    }

    //ONLY FOR TESTING !!!
    @GetMapping("/favourites")
    public List<Favourite> getFavourites(){
        return this.seriesService.findAllFavourites();
    }

}
