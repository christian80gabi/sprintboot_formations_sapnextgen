package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.LevelExperienceDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.LevelExperience;
import tn.gov.douane.formations.api.repository.LevelExperienceRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LevelExperienceServiceImpl implements LevelExperienceService {

    @Autowired
    private LevelExperienceRepository repo;

    public LevelExperienceServiceImpl() {
        super();
    }

    public LevelExperienceServiceImpl(LevelExperienceRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<LevelExperience> getAllLevelExperience() {
        return this.repo.findAll();
    }

    @Override
    public LevelExperience getLevelExperienceById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Level experience not found with id :"+objId)
                );
    }

    @Override
    public LevelExperience getLevelExperienceByCode(String code) {

        List<LevelExperience> levelExperiences = repo.findAll();
        LevelExperience resultat = null;

        for (LevelExperience obj : levelExperiences) {
            if (code.equalsIgnoreCase(obj.getLevelExperienceCode())){
                resultat = new LevelExperience(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public LevelExperience createLevelExperience(LevelExperienceDto levelExperienceDto) {

        Timestamp time = GDate.precisionDateTime;
        LevelExperience levelExperience = new LevelExperience();

        levelExperience.setLevelExperienceCode(levelExperienceDto.getLevelExpCode());
        levelExperience.setLevelExperienceDescription(levelExperienceDto.getLevelExpDescription());
        levelExperience.setLevelExperiencePoids(levelExperienceDto.getLevelExpPoids());
        levelExperience.setLevelExperienceCreateAt(time);
        levelExperience.setLevelExperienceUpdateAt(time);
        levelExperience.setLevelExperienceDeleteAt(time);

        levelExperience.setStatut(GStatutObj.ADD);

        return this.repo.save(levelExperience);
    }

    @Override
    public LevelExperience updateLevelExperience(LevelExperienceDto levelExperienceDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        LevelExperience existingLevelExperience = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level experience not found with id :"+objId));

        existingLevelExperience.setLevelExperienceCode(levelExperienceDto.getLevelExpCode());
        existingLevelExperience.setLevelExperienceDescription(levelExperienceDto.getLevelExpDescription());
        existingLevelExperience.setLevelExperiencePoids(levelExperienceDto.getLevelExpPoids());
        existingLevelExperience.setLevelExperienceUpdateAt(time);

        existingLevelExperience.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingLevelExperience);

    }

    @Override
    public ResponseEntity<LevelExperience> deleteLevelExperience(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        LevelExperience existingLevelExperience = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level experience not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingLevelExperience);
        return ResponseEntity.ok().build();
    }
}
