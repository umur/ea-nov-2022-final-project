package imdb.com.series.Service;

import imdb.com.series.Entity.Favourite;
import imdb.com.series.Entity.Series;

import java.util.List;

public interface SeriesService {

    List<Series> findAllSeries();
    List<Series> findFavouriteSeriesByUserId(Integer userId);

    //Test ONLY!!!!!
    List<Favourite> findAllFavourites();

    void deleteFavouriteById(Integer id);

}
