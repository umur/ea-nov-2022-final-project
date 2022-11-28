package project.series_service.service;

import project.series_service.entity.Serie;

public interface SerieService {
    void saveSerie(Serie serie);
    void deleteSerie(long digitalVideoId);
    Serie findByDigitalVideoId(long digitalVideoId);
}
