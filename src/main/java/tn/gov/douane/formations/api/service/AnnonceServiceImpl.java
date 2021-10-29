package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.AnnonceDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Annonce;
import tn.gov.douane.formations.api.repository.AnnonceRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    private AnnonceRepository repo;

    public AnnonceServiceImpl() {
        super();
    }

    public AnnonceServiceImpl(AnnonceRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Annonce> getAllAnnonce() { return this.repo.findAll(); }

    @Override
    public Annonce getAnnonceById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Annonce not found with id :"+objId)
                );
    }

    @Override
    public Annonce getAnnonceByLabel(AnnonceDto annonceDto) {

        List<Annonce> annonces = repo.findAll();
        Annonce resultat = null;
        String label = annonceDto.getAnnonceLabel();
        for (Annonce obj : annonces) {
            if (label.equalsIgnoreCase(obj.getAnnonceLabel())){
                resultat = new Annonce();
                resultat.setAnnonceLabel(obj.getAnnonceLabel());
                break;
            }
        }

        return resultat;
    }

    @Override
    public Annonce createAnnonce(AnnonceDto annonceDto) {

        Timestamp time = GDate.precisionDateTime;
        Annonce annonce = new Annonce();
        annonce.setAnnonceLabel(annonceDto.getAnnonceLabel());
        annonce.setAnnonceDescription(annonceDto.getAnnonceDescription());
        annonce.setPosteId(annonceDto.getPoste());
        annonce.setAnnonceCreateAt(time);
        annonce.setAnnonceUpdateAt(time);
        annonce.setAnnonceDeleteAt(time);
        annonce.setStatut(GStatutObj.ADD);
        return this.repo.save(annonce);
    }

    @Override
    public Annonce updateAnnonce(AnnonceDto annonceDto, long objId) {
        Timestamp time = GDate.precisionDateTime;
        Annonce existingAnnonce = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Annonce not found with id :"+objId));
        existingAnnonce.setAnnonceLabel(annonceDto.getAnnonceLabel());
        existingAnnonce.setAnnonceDescription(annonceDto.getAnnonceDescription());
        existingAnnonce.setPosteId(annonceDto.getPoste());
        existingAnnonce.setAnnonceUpdateAt(time);
        existingAnnonce.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingAnnonce);
    }

    @Override
    public ResponseEntity<Annonce> deleteAnnonce(long objId) {
        //Timestamp time = GDate.precisionDateTime;
        Annonce existingAnnonce = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Annonce not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingAnnonce);
        return ResponseEntity.ok().build();
    }
}
