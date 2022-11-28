package project.series_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.series_service.entity.Serie;
import project.series_service.service.serviceImpl.SerieServiceImpl;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieServiceImpl serieServiceImpl;

    @PostMapping
    public ResponseEntity<Serie> saveMovie(@RequestBody Serie serie){
        serieServiceImpl.saveSerie(serie);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }

    @GetMapping("/{digitalVideoId}")
    public ResponseEntity<Serie> getSerieByDigitalVideoId(@PathVariable long digitalVideoId ){
        Serie serie=serieServiceImpl.findByDigitalVideoId(digitalVideoId);
        return new ResponseEntity<>(serie, HttpStatus.OK);
    }


}
