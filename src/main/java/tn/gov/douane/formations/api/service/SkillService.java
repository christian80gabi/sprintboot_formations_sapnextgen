package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.SkillDto;
import tn.gov.douane.formations.api.model.Skill;

import java.util.List;

public interface SkillService {
    public List<Skill> getAllSkill();
    public Skill getSkillById(long objId);
    public Skill getSkillByCode(String code);
    public Skill createSkill(SkillDto skillDto);
    public Skill updateSkill(SkillDto skillDto, long objId);
    public ResponseEntity<Skill> deleteSkill(long objId);
}