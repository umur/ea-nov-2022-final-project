package project.rating_service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.rating_service.entity.Rating;
import project.rating_service.service.RatingService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/rating")
@Slf4j
public class Controller {
    @Autowired
    private RatingService ratingService;
    private static final DecimalFormat df = new DecimalFormat("0.0");

    @PostMapping("/add")
    public String addRating(@RequestBody Rating rating) {
        ratingService.addRating(rating);
        log.info("Added rating");
        return "rating saved ";
    }


    @GetMapping("/getbyid")
    public Rating getRatingById(@PathVariable("id") Long id) {
        return ratingService.getRating(id);
    }

    @GetMapping("/getbyuser/{id}")
    public List<Rating> getUserRatings(@PathVariable("id") Long userId) {
       log.info("getting rating by user id");
        return ratingService.getRatingByUser(userId);
    }

    @DeleteMapping("/remove")
    public void removeRating(@PathVariable("id") Long ratingId){
        log.info("removed rating id "+ratingId);
        ratingService.removeRating(ratingId);
    }

    @GetMapping("/averagerating/{id}")
    public double getAverageRating(@PathVariable("id") Long movieId){
        log.info("calculating the average rating for movie/series id "+movieId);
        return Objects.isNull(Double.parseDouble
                (df.format(ratingService.getAverageRating(movieId))))?
                0.0:Double.parseDouble(df.format(ratingService.getAverageRating(movieId)));
    }
}
