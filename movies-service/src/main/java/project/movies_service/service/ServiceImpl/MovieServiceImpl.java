package project.movies_service.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.movies_service.entity.Movie;
import project.movies_service.repository.MovieRepo;
import project.movies_service.service.MovieService;

import javax.transaction.Transactional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public void saveMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    @Transactional
    public void deleteMovie(long digitalVideoId) {
           Movie movie =movieRepo.findByDigitalVideoId(digitalVideoId);
           if(movie==null);
           else
           movie.setDeleted(true);
    }


    @Override
    public Movie getMovie(long digitalVideoId) {
        return movieRepo.findByDigitalVideoId(digitalVideoId);
    }
}
