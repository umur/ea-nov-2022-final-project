package imdb.com.series.Controller;

import imdb.com.series.Entity.Series;
import imdb.com.series.Service.SeriesServiceImpl;
import imdb.com.series.rabbitmq.Publisher.service.RabbitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
@AllArgsConstructor
public class SeriesController {

    @Autowired
    private SeriesServiceImpl seriesService;

    @Autowired
    private RabbitService rabbitService;

    @GetMapping
    public List<Series> findAllSeries() {
        return seriesService.findAllSeries();
    }
    @GetMapping("/{id}")
    public Series findAllSeriesById(@PathVariable Integer id) {
        return seriesService.findAllSeriesById(id);
    }

    @PostMapping
    public void saveSeries(@RequestBody Series series){
        seriesService.saveSeries(series);
    }
    @PutMapping
    public void updateSeries(@RequestBody Series series){
        seriesService.updateSeries(series);
    }
    @DeleteMapping("/{seriesId}")
    public void deleteSeriesById(@PathVariable Integer seriesId){
        seriesService.deleteAllBySeriesid(seriesId);
        seriesService.deleteSeriesById(seriesId);
        // send massage to rating by kafka
        this.rabbitService.sendCommentMessage("delete " + seriesId);
    }


    @GetMapping("/users/{userId}")
    public List<Series> findAllSeriesByUserId(@PathVariable int userId){
        return seriesService.findAllSeriesByUserId(userId);
    }
    @GetMapping("users/{ownerId}")
    public List<Series> findAllSeriesByOwner(@PathVariable int ownerId) {
        return seriesService.findAllSeriesByOwnerid(ownerId);
    }

    @DeleteMapping("users/{userId}")
    public void deleteSeriesByUserId(@PathVariable int userId){
        seriesService.deleteAllByUserid(userId);
    }

    @DeleteMapping("users/{ownerId}")
    public void deleteSeriesByOwnerId(@PathVariable int ownerId){
        seriesService.deleteSeriesByOwnerId(ownerId);
    }
}
