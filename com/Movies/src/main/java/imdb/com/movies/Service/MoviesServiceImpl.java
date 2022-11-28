package imdb.com.movies.Service;

import imdb.com.movies.Entity.Favourite;
import imdb.com.movies.Entity.Movies;
import imdb.com.movies.Repository.FavouriteRepository;
import imdb.com.movies.Repository.MoviesRepository;
import imdb.com.movies.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MoviesServiceImpl implements MoviesService {

    private RabbitService rabbitService;
    private FavouriteRepository favouriteRepository;
    private MoviesRepository moviesRepository;

    @Override
    public List<Movies> findAllMovies() {
        return moviesRepository.findAll();
    }

    @Override
    public List<Movies> findFavouriteMoviesByUserId(Integer userId) {
        return favouriteRepository.findFavouriteMoviesByUserId(userId);
    }

    @Override
    public List<Favourite> findAllFavourites() {
        return favouriteRepository.findAll();
    }

    @Override
    public void deleteFavouriteById(Integer id) {
        this.favouriteRepository.deleteById(id);
    }

    @RabbitListener(queues = {"movies-queue"})
    @Override
    public void deleteFavouriteByUserId(String id) {
        Integer userId= Integer.parseInt(id.split(" ")[1]);
        favouriteRepository.findFavouriteUserId(userId).forEach(favourite -> {
            favouriteRepository.deleteById(favourite.getId());
        });
        this.rabbitService.sendCommentMessage("delete " + userId);

    }
}
