package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.SkillDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.repository.SkillRepository;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repo;

    public SkillServiceImpl() {
        super();
    }

    public SkillServiceImpl(SkillRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Skill> getAllSkill() {
        return this.repo.findAll();
    }

    @Override
    public Skill getSkillById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Skill not found with id :"+objId)
                );
    }

    @Override
    public Skill getSkillByCode(String code) {

        List<Skill> skills = repo.findAll();
        Skill resultat = null;

        for (Skill obj : skills) {
            if (code.equalsIgnoreCase(obj.getSkillCode())){
                resultat = new Skill(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public Skill createSkill(SkillDto skillDto) {

        Timestamp time = GDate.precisionDateTime;
        Date skillPeriodStart = Date.valueOf(skillDto.getSkillPeriodStart());
        Date skillPeriodEnd = Date.valueOf(skillDto.getSkillPeriodEnd());
        Skill skill = new Skill();

        skill.setSkillCode(skillDto.getSkillCode());
        skill.setSkillName(skillDto.getSkillName());
        skill.setSkillDescription(skillDto.getSkillDescription());
        skill.setSkillDocument(skillDto.getSkillDocument());
        skill.setSkillLink(skillDto.getSkillLink());
        skill.setSkillPeriodStart(skillPeriodStart);
        skill.setSkillPeriodEnd(skillPeriodEnd);
        skill.setSkillQuota(skillDto.getSkillQuota());
        skill.setSkillPlace(skillDto.getSkillPlace());
        skill.setSkillResult(skillDto.getSkillResult());
        skill.setSkillSectionId(skillDto.getSkillSection());
        skill.setLevelSkillId(skillDto.getLevelSkill());
        skill.setSkillCreateAt(time);
        skill.setSkillUpdateAt(time);
        skill.setSkillDeleteAt(time);
        skill.setStatut(GStatutObj.ADD);

        return this.repo.save(skill);
    }

    @Override
    public Skill updateSkill(SkillDto skillDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Date skillPeriodStart = Date.valueOf(skillDto.getSkillPeriodStart());
        Date skillPeriodEnd = Date.valueOf(skillDto.getSkillPeriodEnd());
        Skill existingSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Skill not found with id :"+objId));

        existingSkill.setSkillCode(skillDto.getSkillCode());
        existingSkill.setSkillName(skillDto.getSkillName());
        existingSkill.setSkillDescription(skillDto.getSkillDescription());
        existingSkill.setSkillDocument(skillDto.getSkillDocument());
        existingSkill.setSkillLink(skillDto.getSkillLink());
        existingSkill.setSkillPeriodStart(skillPeriodStart);
        existingSkill.setSkillPeriodEnd(skillPeriodEnd);
        existingSkill.setSkillQuota(skillDto.getSkillQuota());
        existingSkill.setSkillPlace(skillDto.getSkillPlace());
        existingSkill.setSkillResult(skillDto.getSkillResult());
        existingSkill.setSkillSectionId(skillDto.getSkillSection());
        existingSkill.setLevelSkillId(skillDto.getLevelSkill());
        existingSkill.setSkillUpdateAt(time);
        existingSkill.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingSkill);
    }

    @Override
    public ResponseEntity<Skill> deleteSkill(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Skill existingSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Skill not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingSkill);
        return ResponseEntity.ok().build();
    }
}
