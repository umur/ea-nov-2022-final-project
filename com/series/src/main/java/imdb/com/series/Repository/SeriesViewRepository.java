package imdb.com.series.Repository;

import imdb.com.series.Entity.Series;
import imdb.com.series.Entity.SeriesView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeriesViewRepository extends CrudRepository<SeriesView, Integer> {
//    @Query(value = "select s from Series s inner join SeriesView sv on sv.seriesid=s.id where sv.userid=?1")
//    List<Series> findAllSeriesByUserId(Integer userId);
//
//    void deleteAllByUserid(Integer userId);
//    void deleteAllBySeriesid(Integer seriesId);


}
