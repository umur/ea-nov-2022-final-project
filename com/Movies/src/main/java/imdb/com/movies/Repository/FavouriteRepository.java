package imdb.com.movies.Repository;

import imdb.com.movies.Entity.Favourite;
import imdb.com.movies.Entity.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, Integer> {


    @Query(value = "select m from Movies m inner join Favourite f on f.userid=m.id where f.userid=?1")
    List<Movies> findFavouriteMoviesByUserId(Integer userId);

    List<Favourite> findAll();

    void deleteById(Integer id);

    @Query(value = "select f from Favourite f where f.userid=?1")
    List<Favourite> findFavouriteUserId(Integer userId);

}
