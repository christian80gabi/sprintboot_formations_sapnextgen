package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.FormationDto;
import tn.gov.douane.formations.api.model.Formation;

import java.util.List;

public interface FormationService {
    public List<Formation> getAllFormation();
    public Formation getFormationById(long objId);
    public Formation getFormationByLabel(String code);
    public Formation createFormation(FormationDto formationDto);
    public Formation updateFormation(FormationDto formationDto, long objId);
    public ResponseEntity<Formation> deleteFormation(long objId);
}
