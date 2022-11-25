package imdb.com.movies.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Movies {

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
    private int ownerid;




}
