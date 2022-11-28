package project.series_service.repository;

import org.springframework.data.repository.CrudRepository;
import project.series_service.entity.Serie;

public interface SerieRepo extends CrudRepository<Serie,Long> {
   Serie findByDigitalVideoId(long digitalVideoId);
}
