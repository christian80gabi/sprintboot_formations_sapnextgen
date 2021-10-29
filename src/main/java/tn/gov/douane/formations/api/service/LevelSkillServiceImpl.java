package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.LevelSkillDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.LevelSkill;
import tn.gov.douane.formations.api.repository.LevelSkillRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class LevelSkillServiceImpl implements LevelSkillService {

    @Autowired
    private LevelSkillRepository repo;

    public LevelSkillServiceImpl() {
        super();
    }

    public LevelSkillServiceImpl(LevelSkillRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<LevelSkill> getAllLevelSkill() {
        return this.repo.findAll();
    }

    @Override
    public LevelSkill getLevelSkillById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Level skill not found with id :"+objId)
                );
    }

    @Override
    public LevelSkill getLevelSkillByCode(String code) {

        List<LevelSkill> levelSkills = repo.findAll();
        LevelSkill resultat = null;

        for (LevelSkill obj : levelSkills) {
            if (code.equalsIgnoreCase(obj.getLevelSkillCode())){
                resultat = new LevelSkill(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public LevelSkill createLevelSkill(LevelSkillDto levelSkillDto) {

        Timestamp time = GDate.precisionDateTime;
        LevelSkill levelSkill = new LevelSkill();

        levelSkill.setLevelSkillCode(levelSkillDto.getLevelSkillCode());
        levelSkill.setLevelSkillDescription(levelSkillDto.getLevelSkillDescription());
        levelSkill.setLevelSkillPoids(levelSkillDto.getLevelSkillPoids());
        levelSkill.setLevelSkillCreateAt(time);
        levelSkill.setLevelSkillUpdateAt(time);
        levelSkill.setLevelSkillDeleteAt(time);
        levelSkill.setStatut(GStatutObj.ADD);

        return this.repo.save(levelSkill);
    }

    @Override
    public LevelSkill updateLevelSkill(LevelSkillDto levelSkillDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        LevelSkill existingLevelSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level skill not found with id :"+objId));

        existingLevelSkill.setLevelSkillCode(levelSkillDto.getLevelSkillCode());
        existingLevelSkill.setLevelSkillDescription(levelSkillDto.getLevelSkillDescription());
        existingLevelSkill.setLevelSkillPoids(levelSkillDto.getLevelSkillPoids());
        existingLevelSkill.setLevelSkillUpdateAt(time);
        existingLevelSkill.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingLevelSkill);
    }

    @Override
    public ResponseEntity<LevelSkill> deleteLevelSkill(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        LevelSkill existingLevelSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Level skill not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingLevelSkill);
        return ResponseEntity.ok().build();
    }
}
