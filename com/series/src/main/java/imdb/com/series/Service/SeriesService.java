package imdb.com.series.Service;

import imdb.com.series.Entity.Series;

import java.util.List;

public interface SeriesService {

    List<Series> findAllSeries();
    List<Series> findAllSeriesByUserId(Integer userId);
    List<Series> findAllSeriesByOwnerid(Integer ownerId);
    Series findAllSeriesById(Integer seriesId);
    void deleteSeriesByOwnerId(Integer ownerId);
    void saveSeries(Series series);
    void updateSeries(Series series);
    void deleteSeriesById(Integer seriesId);

    void deleteAllByUserid(Integer userId);
    void deleteAllBySeriesid(Integer seriesId);


}
