package imdb.com.movies.Service;

import imdb.com.movies.Entity.Favourite;
import imdb.com.movies.Entity.Movies;

import java.util.List;

public interface MoviesService {

    List<Movies> findAllMovies();
    List<Movies> findFavouriteMoviesByUserId(Integer userId);

    //Test ONLY!!!!!
    List<Favourite> findAllFavourites();
    void deleteFavouriteById(Integer id);

    void deleteFavouriteByUserId(String id);

}
