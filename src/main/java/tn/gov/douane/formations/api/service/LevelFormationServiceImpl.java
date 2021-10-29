package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.LevelFormationDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.LevelFormation;
import tn.gov.douane.formations.api.repository.LevelFormationRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class LevelFormationServiceImpl implements LevelFormationService {

    @Autowired
    private LevelFormationRepository repo;

    public LevelFormationServiceImpl() {
        super();
    }

    public LevelFormationServiceImpl(LevelFormationRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<LevelFormation> getAllLevelFormation() {
        return this.repo.findAll();
    }

    @Override
    public LevelFormation getLevelFormationById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Level formation not found with id :"+objId)
                );
    }

    @Override
    public LevelFormation getLevelFormationByLabel(String code) {

        List<LevelFormation> levelFormations = repo.findAll();
        LevelFormation resultat = null;

        for (LevelFormation obj : levelFormations) {
            if (code.equalsIgnoreCase(obj.getLevelFormationCode())){
                resultat = new LevelFormation(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public LevelFormation createLevelFormation(LevelFormationDto levelFormationDto) {

        Timestamp time = GDate.precisionDateTime;
        LevelFormation levelFormation = new LevelFormation();

        levelFormation.setLevelFormationCode(levelFormationDto.getLevelFormationCode());
        levelFormation.setLevelFormationDescription(levelFormationDto.getLevelFormationDescription());
        levelFormation.setLevelFormationPoids(levelFormationDto.getLevelFormationPoids());
        levelFormation.setLevelFormationCreateAt(time);
        levelFormation.setLevelFormationUpdateAt(time);
        levelFormation.setLevelFormationDeleteAt(time);
        levelFormation.setStatut(GStatutObj.ADD);

        return this.repo.save(levelFormation);
    }

    @Override
    public LevelFormation updateLevelFormation(LevelFormationDto levelFormationDto, long objId) {

        Timestamp time = GDate.precisionDateTime;

        LevelFormation existingLevelFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level formation not found with id :"+objId));

        existingLevelFormation.setLevelFormationCode(levelFormationDto.getLevelFormationCode());
        existingLevelFormation.setLevelFormationDescription(levelFormationDto.getLevelFormationDescription());
        existingLevelFormation.setLevelFormationPoids(levelFormationDto.getLevelFormationPoids());
        existingLevelFormation.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingLevelFormation);
    }

    @Override
    public ResponseEntity<LevelFormation> deleteLevelFormation(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        LevelFormation existingLevelFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level formation not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingLevelFormation);
        return ResponseEntity.ok().build();
    }
}
