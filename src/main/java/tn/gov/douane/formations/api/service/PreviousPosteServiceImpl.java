package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.PreviousPosteDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.PreviousPoste;
import tn.gov.douane.formations.api.repository.PosteRepository;
import tn.gov.douane.formations.api.repository.PreviousPosteRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PreviousPosteServiceImpl implements PreviousPosteService {

    @Autowired
    private PreviousPosteRepository repo;

    @Autowired
    private PosteRepository repoPoste;

    public PreviousPosteServiceImpl() {
        super();
    }

    public PreviousPosteServiceImpl(PreviousPosteRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<PreviousPoste> getAllPreviousPoste() {
        return this.repo.findAll();
    }

    @Override
    public PreviousPoste getPreviousPosteById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Previous poste not found with id :"+objId)
                );
    }

    @Override
    public List<Poste> getPreviousPosteByPoste(long posteId) {

        List<PreviousPoste> previousPostes = repo.findAll();
        List<Poste> resultat = new ArrayList<Poste>();

        for (PreviousPoste obj : previousPostes) {

            if (posteId == obj.getPosteId().getId()){
                resultat.add(obj.getPostePreviousId());
            }
        }

        return resultat;
    }

    @Override
    public PreviousPoste createPreviousPoste(PreviousPosteDto previousPosteDto) {

        Timestamp time = GDate.precisionDateTime;
        PreviousPoste previousPoste = new PreviousPoste();

        previousPoste.setPostePreviousId(previousPosteDto.getPreviousPoste());
        previousPoste.setPosteId(previousPosteDto.getPoste());
        previousPoste.setPreviousPosteCreateAt(time);
        previousPoste.setPreviousPosteUpdateAt(time);
        previousPoste.setPreviousPosteDeleteAt(time);
        previousPoste.setStatut(GStatutObj.ADD);

        return this.repo.save(previousPoste);
    }

    @Override
    public PreviousPoste updatePreviousPoste(PreviousPosteDto previousPosteDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        PreviousPoste existingPreviousPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Previous poste not found with id :"+objId));

        existingPreviousPoste.setPostePreviousId(previousPosteDto.getPreviousPoste());
        existingPreviousPoste.setPosteId(previousPosteDto.getPoste());
        existingPreviousPoste.setPreviousPosteUpdateAt(time);
        existingPreviousPoste.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingPreviousPoste);
    }

    @Override
    public ResponseEntity<PreviousPoste> deletePreviousPoste(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        PreviousPoste existingPreviousPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Previous poste not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingPreviousPoste);
        return ResponseEntity.ok().build();
    }
}
