package imdb.com.series.Repository;


import imdb.com.series.Entity.Favourite;
import imdb.com.series.Entity.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, Integer> {


    @Query(value = "select s from Series s inner join Favourite f on f.seriesid=s.id where f.userid=?1")
    List<Series> findFavouriteSeriesByUserId(Integer userId);

    List<Favourite> findAll();

    void deleteById(Integer id);

}
