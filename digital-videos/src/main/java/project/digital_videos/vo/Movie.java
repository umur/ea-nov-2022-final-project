package project.digital_videos.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int duration;
    private long DigitalVideoId;
    private boolean isDeleted;
}
