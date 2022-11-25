package imdb.com.movies.Repository;

import imdb.com.movies.Entity.Movies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
    List<Movies> findAll();

}
