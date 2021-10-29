package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.FormationSectionDto;
import tn.gov.douane.formations.api.model.FormationSection;

import java.util.List;

public interface FormationSectionService {
    public List<FormationSection> getAllFormationSection();
    public FormationSection getFormationSectionById(long objId);
    public FormationSection getFormationSectionByCode(String code);
    public FormationSection createFormationSection(FormationSectionDto formationSectionDto);
    public FormationSection updateFormationSection(FormationSectionDto formationSectionDto, long objId);
    public ResponseEntity<FormationSection> deleteFormationSection(long objId);
}