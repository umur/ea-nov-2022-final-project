package project.rating_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.rating_service.entity.Rating;

import java.util.List;

@Repository
public interface RatingRepo extends CrudRepository<Rating,Long> {
    List<Rating> findAllByUserId(Long userID);
    @Query("select avg(r.rate) from Rating r where r.movieId = ?1")
   Double getAverageRating(Long movieId);
}
