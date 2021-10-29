package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.PosteStatutDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.PosteStatut;
import tn.gov.douane.formations.api.repository.PosteStatutRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PosteStatutServiceImpl implements PosteStatutService{

    @Autowired
    private PosteStatutRepository repo;

    public PosteStatutServiceImpl() {
        super();
    }

    public PosteStatutServiceImpl(PosteStatutRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<PosteStatut> getAllPosteStatut() {
        return this.repo.findAll();
    }

    @Override
    public PosteStatut getPosteStatutById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Poste statut not found with id :"+objId)
                );
    }

    @Override
    public PosteStatut getPosteStatutByLabel(PosteStatutDto posteStatutDto) {
        List<PosteStatut> posteStatuts = repo.findAll();
        PosteStatut resultat = null;
        String label = posteStatutDto.getPosteStatutLabel();
        for (PosteStatut obj : posteStatuts) {
            if (label.equalsIgnoreCase(obj.getPosteStatutLabel())){
                resultat = new PosteStatut();
                resultat.setPosteStatutLabel(obj.getPosteStatutLabel());
                break;
            }
        }

        return resultat;
    }

    @Override
    public PosteStatut createPosteStatut(PosteStatutDto posteStatutDto) {

        Timestamp time = GDate.precisionDateTime;
        PosteStatut posteStatut = new PosteStatut();
        posteStatut.setPosteStatutLabel(posteStatutDto.getPosteStatutLabel());
        posteStatut.setPosteStatutFlag(true);
        posteStatut.setCreateAt(time);
        posteStatut.setUpdateAt(time);
        posteStatut.setDeleteAt(time);
        posteStatut.setStatut(GStatutObj.ADD);
        return this.repo.save(posteStatut);
    }

    @Override
    public PosteStatut updatePosteStatut(PosteStatutDto posteStatutDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        PosteStatut existingPosteStatut = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Poste statut not found with id :"+objId));
        existingPosteStatut.setPosteStatutLabel(posteStatutDto.getPosteStatutLabel());
        existingPosteStatut.setPosteStatutFlag(posteStatutDto.isPosteStatutFlag());
        existingPosteStatut.setUpdateAt(time);
        existingPosteStatut.setStatut(GStatutObj.UPDATE);
        return this.repo.save(existingPosteStatut);
    }

    @Override
    public ResponseEntity<PosteStatut> deletePosteStatut(long objId) {
        //Timestamp time = GDate.precisionDateTime;
        PosteStatut existingPosteStatut = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Poste statut not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingPosteStatut);
        return ResponseEntity.ok().build();
    }
}
