package project.digital_videos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.digital_videos.entity.Actor;
import project.digital_videos.vo.Comment;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DigitalVideoDto {
    private long id;
    private String type;
    private String name;
    private String genre;
    private String director;
    private double rating;
    private int numberOfEpisods;
    private int totalDuration;
    private int duration;
    List<Actor> actors;
    List<Comment> comments;
}
