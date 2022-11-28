package project.digital_videos.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.digital_videos.dto.DigitalVideoDto;
import project.digital_videos.entity.DigitalVideo;
import project.digital_videos.repository.DigitalVideoRepo;
import project.digital_videos.service.DigitalVideoService;
import project.digital_videos.vo.Comment;
import project.digital_videos.vo.Movie;
import project.digital_videos.vo.Serie;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class DigitalVideoServiceImpl implements DigitalVideoService {

    @Autowired
    private DigitalVideoRepo digitalVideoRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String saveDigitalVideo(DigitalVideoDto digitalVideoDto) {
        if(digitalVideoDto.getType().equals("movie")){
        DigitalVideo digitalVideo=mapper.map(digitalVideoDto,DigitalVideo.class);
        digitalVideo.setDeleted(false);
        digitalVideoRepo.save(digitalVideo);
        DigitalVideo digitalVideo1=digitalVideoRepo.findByName(digitalVideo.getName());
        long digitalVideoId =digitalVideo1.getId();
        Movie movie=mapper.map(digitalVideoDto, Movie.class);
        movie.setDigitalVideoId(digitalVideoId);
        movie.setDeleted(false);
        Movie movieResponse = restTemplate.postForObject("http://localhost:8082/movies",
                movie, Movie.class);
        return "movie saved succesfully";
        }
        if(digitalVideoDto.getType().equals("serie")){
            DigitalVideo digitalVideo=mapper.map(digitalVideoDto,DigitalVideo.class);
            digitalVideo.setDeleted(false);
            digitalVideoRepo.save(digitalVideo);
            DigitalVideo digitalVideo1=digitalVideoRepo.findByName(digitalVideo.getName());
            long digitalVideoId =digitalVideo1.getId();
            Serie serie=mapper.map(digitalVideoDto, Serie.class);
            serie.setDigitalVideoId(digitalVideoId);
            serie.setDeleted(false);
            Serie serieResponse = restTemplate.postForObject("http://localhost:8081/series",
                    serie, Serie.class);
            return "serie saved succesfully";
        }
        return "not saved , type must be specified";
    }

    @Override
    @Transactional
    public String deleteDigitalVideo(long digitalVideoId) {
        try{
            DigitalVideo digitalVideo=digitalVideoRepo.findById(digitalVideoId).get();
            digitalVideo.setDeleted(true);
            template.convertAndSend("message_exchange","comment_routingKey",digitalVideoId);
            String type=digitalVideo.getType();

            if(type.equals("movie")){
                template.convertAndSend("message_exchange","movie_routingKey",digitalVideoId);
            }

            if(type.equals("serie")){
                template.convertAndSend("message_exchange","series_routingKey",digitalVideoId);
            }
            return "item with id " + digitalVideoId + "deleted successfully";
        }catch (NoSuchElementException e){ return "item with id " + digitalVideoId + " does not exist";}

    }

    @Override
    public DigitalVideoDto getDigitalVideo(long digitalVideoId) {
        DigitalVideo digitalVideo=digitalVideoRepo.findById(digitalVideoId).get();
        if(digitalVideo.isDeleted()==true)
            return null;

        List<Comment> comments = restTemplate.getForObject("http://localhost:8083/comments/"+digitalVideoId,
               List.class);
        Double rating =  restTemplate.getForObject("http://localhost:8084/rating/averagerating/" +
                        +digitalVideoId,
               Double.class);

        if(digitalVideo.getType().equals("movie")){
            Movie movieResponse = restTemplate.getForObject("http://localhost:8082/movies/"+digitalVideoId,
                    Movie.class);
            DigitalVideoDto digitalVideoDto=mapper.map(digitalVideo,DigitalVideoDto.class);
            mapper.map(movieResponse,digitalVideoDto);
            digitalVideoDto.setComments(comments);
            digitalVideoDto.setRating(rating);
            return digitalVideoDto;
        }
        if(digitalVideo.getType().equals("serie")){
            Serie serieResponse = restTemplate.getForObject("http://localhost:8081/series/"+digitalVideoId,
                    Serie.class);
            DigitalVideoDto digitalVideoDto=mapper.map(digitalVideo,DigitalVideoDto.class);
            mapper.map(serieResponse,digitalVideoDto);
            digitalVideoDto.setComments(comments);
            digitalVideoDto.setDuration(0);
            digitalVideoDto.setRating(rating);
            return digitalVideoDto;
        }

   return null;

    }

    public List<DigitalVideoDto> getAll(){
        List<DigitalVideoDto> digitalVideoDtoList=new ArrayList<>();
        List<DigitalVideo> digitalVideos =new ArrayList<>();
        Iterable<DigitalVideo> iterable=digitalVideoRepo.findAll();
        iterable.forEach(digitalVideos::add);
        List <DigitalVideo> filteredDigitalVideos=digitalVideos.stream().filter(d->d.isDeleted()==false).toList();

        filteredDigitalVideos.forEach(s->{


            long digitalVideoId =s.getId();
            List<Comment> comments = restTemplate.getForObject("http://localhost:8083/comments/"+digitalVideoId,
                            List.class);
            double rating =  restTemplate.getForObject("http://localhost:8084/rating/averagerating/" + +digitalVideoId, Double.class);
            if(s.getType().equals("movie")){
            Movie movieResponse = restTemplate.getForObject("http://localhost:8082/movies/"+digitalVideoId,
                    Movie.class);
            DigitalVideoDto digitalVideoDto=mapper.map(s,DigitalVideoDto.class);
            mapper.map(movieResponse,digitalVideoDto);
            digitalVideoDto.setComments(comments);
            digitalVideoDto.setRating(rating);
            digitalVideoDtoList.add(digitalVideoDto);
        }
            if(s.getType().equals("serie")){

                Serie serieResponse = restTemplate.getForObject("http://localhost:8081/series/"+digitalVideoId,
                        Serie.class);
                DigitalVideoDto digitalVideoDto=mapper.map(s,DigitalVideoDto.class);
                mapper.map(serieResponse,digitalVideoDto);
                digitalVideoDto.setComments(comments);
                digitalVideoDto.setDuration(0);
                digitalVideoDto.setRating(rating);
                digitalVideoDtoList.add(digitalVideoDto);


            }
                }
            );
      return digitalVideoDtoList;
    }
}
