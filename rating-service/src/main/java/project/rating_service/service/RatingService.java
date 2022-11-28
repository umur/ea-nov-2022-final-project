package project.rating_service.service;

import project.rating_service.entity.Rating;

import java.util.List;

public interface RatingService {
    void addRating(Rating rate);
    void removeRating(Long id);
    Rating getRating(Long id);

    List<Rating> getRatingByUser(Long userId);

    double getAverageRating(Long movieId);
}
