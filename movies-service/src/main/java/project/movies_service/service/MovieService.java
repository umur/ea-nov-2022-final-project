package project.movies_service.service;

import project.movies_service.entity.Movie;

public interface MovieService {
    void saveMovie(Movie movie);
    void deleteMovie(long digitalVideoId);
    Movie getMovie(long digitalVideoId);
}
