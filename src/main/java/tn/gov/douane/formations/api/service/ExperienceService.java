package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.ExperienceDto;
import tn.gov.douane.formations.api.model.Experience;

import java.util.List;

public interface ExperienceService {
    public List<Experience> getAllExperience();
    public Experience getExperienceById(long objId);
    public Experience getExperienceByCode(String code);
    public Experience createExperience(ExperienceDto experienceDto);
    public Experience updateExperience(ExperienceDto experienceDto, long objId);
    public ResponseEntity<Experience> deleteExperience(long objId);
}
