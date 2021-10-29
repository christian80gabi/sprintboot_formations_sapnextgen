package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.LevelSkillDto;
import tn.gov.douane.formations.api.model.LevelSkill;

import java.util.List;
public interface LevelSkillService {
    public List<LevelSkill> getAllLevelSkill();
    public LevelSkill getLevelSkillById(long objId);
    public LevelSkill getLevelSkillByCode(String code);
    public LevelSkill createLevelSkill(LevelSkillDto levelSkillDto);
    public LevelSkill updateLevelSkill(LevelSkillDto levelSkillDto, long objId);
    public ResponseEntity<LevelSkill> deleteLevelSkill(long objId);
}
