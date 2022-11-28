package project.digital_videos.service;

import org.springframework.stereotype.Service;
import project.digital_videos.dto.DigitalVideoDto;
import project.digital_videos.entity.DigitalVideo;

public interface DigitalVideoService {

    String saveDigitalVideo(DigitalVideoDto digitalVideoDto);
    String deleteDigitalVideo(long  digitalVideoId);
    DigitalVideoDto getDigitalVideo(long digitalVideoId);
}
