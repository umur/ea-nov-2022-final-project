package imdb.com.movies.Controller;


import imdb.com.movies.Entity.Favourite;
import imdb.com.movies.Entity.Movies;
import imdb.com.movies.Service.MoviesServiceImpl;
import imdb.com.movies.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MoviesController {

    private MoviesServiceImpl moviesService;

    @GetMapping
    public List<Movies> findAllMovies() {
        return moviesService.findAllMovies();
    }

    @GetMapping("/favourites/{userId}")
    public List<Movies> findAllMoviesByUserId(@PathVariable int userId){
        return moviesService.findFavouriteMoviesByUserId(userId);
    }

    //ONLY FOR TESTING !!!
    @GetMapping("/favourites")
    public List<Favourite> getFavourites(){
        return this.moviesService.findAllFavourites();
    }

}
