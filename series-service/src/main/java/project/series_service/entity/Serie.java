package project.series_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int numberOfEpisods;
    private int totalDuration;
    private boolean isDeleted;
    private long digitalVideoId;
}
