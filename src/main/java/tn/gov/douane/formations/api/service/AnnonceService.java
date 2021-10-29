package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.AnnonceDto;
import tn.gov.douane.formations.api.model.Annonce;

import java.util.List;

public interface AnnonceService {
    public List<Annonce> getAllAnnonce();
    public Annonce getAnnonceById(long objId);
    public Annonce getAnnonceByLabel(AnnonceDto annonceDto);
    public Annonce createAnnonce(AnnonceDto annonceDto);
    public Annonce updateAnnonce(AnnonceDto annonceDto, long objId);
    public ResponseEntity<Annonce> deleteAnnonce(long objId);
}
