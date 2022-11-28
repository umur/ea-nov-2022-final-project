package project.digital_videos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DigitalVideo {
@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String genre;
    private String director;
    private boolean isDeleted;
    private String type;

    @OneToMany(mappedBy = "digitalVideo",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Actor> actors;


}
