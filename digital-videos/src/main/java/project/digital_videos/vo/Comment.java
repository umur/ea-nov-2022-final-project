package project.digital_videos.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private long userId;
    private long digitalVideoId;
    private boolean isDeleted ;
    private String comment;
}
