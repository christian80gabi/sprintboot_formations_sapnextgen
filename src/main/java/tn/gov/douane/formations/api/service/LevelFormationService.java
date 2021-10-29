package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.LevelFormationDto;
import tn.gov.douane.formations.api.model.LevelFormation;

import java.util.List;

public interface LevelFormationService {
    public List<LevelFormation> getAllLevelFormation();
    public LevelFormation getLevelFormationById(long objId);
    public LevelFormation getLevelFormationByLabel(String code);
    public LevelFormation createLevelFormation(LevelFormationDto levelFormationDto);
    public LevelFormation updateLevelFormation(LevelFormationDto LevelFormationDto, long objId);
    public ResponseEntity<LevelFormation> deleteLevelFormation(long objId);
}