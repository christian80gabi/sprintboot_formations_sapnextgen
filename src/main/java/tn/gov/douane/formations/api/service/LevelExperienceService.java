package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.LevelExperienceDto;
import tn.gov.douane.formations.api.model.LevelExperience;

import java.util.List;

public interface LevelExperienceService {
    public List<LevelExperience> getAllLevelExperience();
    public LevelExperience getLevelExperienceById(long objId);
    public LevelExperience getLevelExperienceByCode(String code);
    public LevelExperience createLevelExperience(LevelExperienceDto levelExperienceDto);
    public LevelExperience updateLevelExperience(LevelExperienceDto levelExperienceDto, long objId);
    public ResponseEntity<LevelExperience> deleteLevelExperience(long objId);
}
