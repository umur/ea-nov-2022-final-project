package project.rating_service.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.rating_service.entity.Rating;
import project.rating_service.repository.RatingRepo;
import project.rating_service.service.RatingService;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public void addRating(Rating comment) {
        ratingRepo.save(comment);
    }

    @Override
    public void removeRating(Long id) {
        ratingRepo.deleteById(id);
    }

    @Override
    public Rating getRating(Long id) {
        var comment = ratingRepo.findById(id);
        return comment.orElseGet(Rating::new);
    }

    @Override
    public List<Rating> getRatingByUser(Long userId) {
        return ratingRepo.findAllByUserId(userId);
    }

    @Override
    public double getAverageRating(Long movieId) {
        Double temp= ratingRepo.getAverageRating(movieId);
        if(temp==null)return 0.0;
        else return temp;
    }
}
