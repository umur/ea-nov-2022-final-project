package imdb.com.series.Repository;

import imdb.com.series.Entity.Series;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Integer> {
    List<Series> findAll();

}
