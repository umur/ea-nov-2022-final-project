package project.digital_videos.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.digital_videos.dto.DigitalVideoDto;

import project.digital_videos.service.serviceImpl.DigitalVideoServiceImpl;

import java.util.List;


@RestController
@RequestMapping("digital_videos")
public class DigitalVideoController {

    @Autowired
    private DigitalVideoServiceImpl digitalVideoServiceImpl;
    @Autowired
    private RabbitTemplate template;



    @PostMapping
    public ResponseEntity<String> saveDigitalVideo(@RequestBody DigitalVideoDto digitalVideoDto){

        String response=digitalVideoServiceImpl.saveDigitalVideo(digitalVideoDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDigitalVideo(@PathVariable("id") long degitalVideoId){
        String response=digitalVideoServiceImpl.deleteDigitalVideo(degitalVideoId);
       return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DigitalVideoDto> getDigitalVideo(@PathVariable("id") long digitalVideoId){
        DigitalVideoDto digitalVideoDto= digitalVideoServiceImpl.getDigitalVideo(digitalVideoId);
        return new ResponseEntity<>(digitalVideoDto,HttpStatus.OK);
    }

    @GetMapping
    public List<DigitalVideoDto> getAll(){
        return digitalVideoServiceImpl.getAll();
    }

}
