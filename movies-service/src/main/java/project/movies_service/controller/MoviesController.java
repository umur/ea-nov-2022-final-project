package project.movies_service.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.movies_service.entity.Movie;
import project.movies_service.repository.MovieRepo;

@RestController
@RequestMapping("movies")
public class MoviesController {
@Autowired
private MovieRepo movieService;


    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
         movieService.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/{digitalVideoId}")
    public ResponseEntity<Movie> getMovieByDigitalVideoId(@PathVariable long digitalVideoId ){
        Movie movie=movieService.findByDigitalVideoId(digitalVideoId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
