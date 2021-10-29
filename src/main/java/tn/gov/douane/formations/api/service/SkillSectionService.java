package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.SkillSectionDto;
import tn.gov.douane.formations.api.model.SkillSection;

import java.util.List;

public interface SkillSectionService {
    public List<SkillSection> getAllSkillSection();
    public SkillSection getSkillSectionById(long objId);
    public SkillSection getSkillByCode(String code);
    public SkillSection createSkillSection(SkillSectionDto skillSectionDto);
    public SkillSection updateSkillSection(SkillSectionDto skillSectionDto, long objId);
    public ResponseEntity<SkillSection> deleteSkillSection(long objId);
}