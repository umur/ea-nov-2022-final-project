package project.digital_videos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.digital_videos.entity.DigitalVideo;
@Repository
public interface DigitalVideoRepo extends CrudRepository<DigitalVideo,Long> {
    DigitalVideo findByName(String name);
}
