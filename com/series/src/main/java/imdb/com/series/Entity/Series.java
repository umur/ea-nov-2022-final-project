package imdb.com.series.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Series {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String releasedyear;
    private String rating;
    private String genre;
    private String director;
    // list of actors, they should be registered somewhere
    private String actor;
    private int duration;
    // if series = false, then it is movie
    private boolean series=true;
    private int ownerid;




}
