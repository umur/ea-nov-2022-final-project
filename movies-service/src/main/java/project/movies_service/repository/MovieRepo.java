package project.movies_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.movies_service.entity.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie,Long> {

    Movie findByDigitalVideoId(long digitalVideoId);
}
