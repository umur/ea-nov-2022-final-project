package project.series_service.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.series_service.entity.Serie;
import project.series_service.repository.SerieRepo;
import project.series_service.service.SerieService;

import javax.transaction.Transactional;

@Service
public class SerieServiceImpl implements SerieService {
    @Autowired
    private SerieRepo serieRepo;
    @Override
    public void saveSerie(Serie serie) {
        serieRepo.save(serie);
    }

    @Override
    @Transactional
    public void deleteSerie(long digitalVideoId) {
            Serie serie = serieRepo.findByDigitalVideoId(digitalVideoId);
            if(serie==null) ;
            else
            serie.setDeleted(true);
    }

    @Override
    public Serie findByDigitalVideoId(long digitalVideoId) {
        return serieRepo.findByDigitalVideoId(digitalVideoId);
    }
}
