package project.digital_videos.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {
    private int numberOfEpisods;
    private int totalDuration;
    private long DigitalVideoId;
    private boolean isDeleted;
}
