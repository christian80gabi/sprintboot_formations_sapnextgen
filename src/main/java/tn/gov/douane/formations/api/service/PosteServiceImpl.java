package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.PosteDto;
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
public class PosteServiceImpl implements PosteService{

    @Autowired
    private PosteRepository repo;

    @Autowired
    private PreviousPosteRepository repoPreviousPoste;

    public PosteServiceImpl() {
        super();
    }

    public PosteServiceImpl(PosteRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Poste> getAllPoste() {
        return this.repo.findAll();
    }

    @Override
    public Poste getPosteById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Poste not found with id :"+objId)
                );
    }

    @Override
    public Poste getPosteByCode(String code) {

        List<Poste> postes = repo.findAll();
        Poste resultat = null;

        for (Poste obj : postes) {
            if (code.equalsIgnoreCase(obj.getPosteCode())){
                resultat = new Poste(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public Poste getPosteByLabel(String label) {

        List<Poste> postes = repo.findAll();
        Poste resultat = null;

        for (Poste obj : postes) {
            if (label.equalsIgnoreCase(obj.getPosteLabel())){
                resultat = new Poste(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public List<Poste> getPosteByPreviousPoste(long previousPosteId) {

        List<PreviousPoste> previousPostes = repoPreviousPoste.findAll();
        List<Poste> resultat = new ArrayList<Poste>();

        for (PreviousPoste obj : previousPostes) {

            if (previousPosteId == obj.getPostePreviousId().getId()){
                resultat.add(obj.getPosteId());
            }
        }

        return resultat;
    }

    @Override
    public Poste createPoste(PosteDto posteDto) {

        Timestamp time = GDate.precisionDateTime;
        Poste poste = new Poste();

        poste.setPosteCode(posteDto.getPosteCode());
        poste.setPosteLabel(posteDto.getPosteLabel());
        poste.setPosteDescription(posteDto.getPosteDescription());
        poste.setPosteStatutId(posteDto.getPosteStatut());
        poste.setGradeId(posteDto.getGrade());
        poste.setPosteCreateAt(time);
        poste.setPosteUpdateAt(time);
        poste.setPosteDeleteAt(time);
        poste.setStatut(GStatutObj.ADD);

        return this.repo.save(poste);
    }

    @Override
    public Poste updatePoste(PosteDto posteDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Poste existingPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Poste not found with id :"+objId));

        existingPoste.setPosteCode(posteDto.getPosteCode());
        existingPoste.setPosteLabel(posteDto.getPosteLabel());
        existingPoste.setPosteStatutId(posteDto.getPosteStatut());
        existingPoste.setGradeId(posteDto.getGrade());
        existingPoste.setPosteUpdateAt(time);
        existingPoste.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingPoste);
    }

    @Override
    public ResponseEntity<Poste> deletePoste(long objId) {

        //Timestamp time = GDate.precisionDateTime;
       Poste existingPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Poste not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingPoste);
        return ResponseEntity.ok().build();
    }
}
