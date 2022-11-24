package imdb.com.series.Service;

import imdb.com.series.Entity.Series;
import imdb.com.series.Repository.SeriesRepository;
import imdb.com.series.Repository.SeriesViewRepository;
import imdb.com.series.rabbitmq.Publisher.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService{


    @Autowired
    private RabbitService rabbitService;
    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeriesViewRepository seriesViewRepository;


    @Override
    public List<Series> findAllSeries() {
        return seriesRepository.findAll();
    }

    @Override
    public List<Series> findAllSeriesByUserId(Integer userId) {
        //return seriesViewRepository.findAllSeriesByUserId(userId);
        return null;
    }

    @Override
    public List<Series> findAllSeriesByOwnerid(Integer ownerId) {
//        return seriesRepository.findAllByOwnerid(ownerId);
        return null;
    }

    @Override
    public Series findAllSeriesById(Integer seriesId) {
        return seriesRepository.findById(seriesId).get();
    }

    @Override
    public void deleteSeriesByOwnerId(Integer ownerId) {
//        List<Series> seriesList= seriesRepository.findAllByOwnerid(ownerId);
//        seriesList.forEach(series -> {
//            seriesViewRepository.deleteAllBySeriesid(series.getId());
//            seriesRepository.deleteById(series.getId());
//            this.rabbitService.sendCommentMessage("delete " + series.getId());
//        });
    }

    @Override
    public void deleteAllByUserid(Integer userId) {
//        seriesViewRepository.deleteAllByUserid(userId);
    }

    @Override
    public void deleteAllBySeriesid(Integer seriesId) {
//        seriesViewRepository.deleteAllBySeriesid(seriesId);
    }

    @Override
    public void saveSeries(Series series) {
        seriesRepository.save(series);
    }

    @Override
    public void updateSeries(Series series) {
        seriesRepository.save(series);
    }

    @Override
    public void deleteSeriesById(Integer seriesId) {
        seriesRepository.deleteById(seriesId);
    }
}
