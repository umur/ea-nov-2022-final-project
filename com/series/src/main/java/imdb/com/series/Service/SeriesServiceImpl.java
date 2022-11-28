package imdb.com.series.Service;

import imdb.com.series.Entity.Favourite;
import imdb.com.series.Entity.Series;
import imdb.com.series.Repository.FavouriteRepository;
import imdb.com.series.Repository.SeriesRepository;
import imdb.com.series.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeriesServiceImpl implements SeriesService {


    private RabbitService rabbitService;

    private FavouriteRepository favouriteRepository;
    private SeriesRepository seriesRepository;


    @Override
    public List<Series> findAllSeries() {
        return seriesRepository.findAll();
    }


    @Override
    public List<Series> findFavouriteSeriesByUserId(Integer userId) {
        return this.favouriteRepository.findFavouriteSeriesByUserId(userId);
    }

    @Override
    public List<Favourite> findAllFavourites() {
        return favouriteRepository.findAll();
    }

    @Override
    public void deleteFavouriteById(Integer id) {
        this.favouriteRepository.deleteById(id);
    }
    @RabbitListener(queues = {"series-queue"})
    @Override
    public void deleteFavouriteByUserId(String id) {
        Integer userId= Integer.parseInt(id.split(" ")[1]);
        favouriteRepository.findFavouriteUserId(userId).forEach(favourite -> {
            favouriteRepository.deleteById(favourite.getId());
        });
        this.rabbitService.sendCommentMessage("delete " + userId);

    }
}
