package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.SkillSectionDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.SkillSection;
import tn.gov.douane.formations.api.repository.SkillSectionRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class SkillSectionServiceImpl implements SkillSectionService {

    @Autowired
    private SkillSectionRepository repo;

    public SkillSectionServiceImpl() {
        super();
    }

    public SkillSectionServiceImpl(SkillSectionRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<SkillSection> getAllSkillSection() {
        return this.repo.findAll();
    }

    @Override
    public SkillSection getSkillSectionById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Skill section not found with id :"+objId)
                );
    }

    @Override
    public SkillSection getSkillByCode(String code) {

        List<SkillSection> skillSections = repo.findAll();
        SkillSection resultat = null;

        for (SkillSection obj : skillSections) {
            if (code.equalsIgnoreCase(obj.getSkillSectionCode())){
                resultat = new SkillSection(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public SkillSection createSkillSection(SkillSectionDto skillSectionDto) {

        Timestamp time = GDate.precisionDateTime;
        SkillSection skillSection = new SkillSection();

        skillSection.setSkillSectionCode(skillSectionDto.getSkillSectionCode());
        skillSection.setSkillSectionName(skillSectionDto.getSkillSectionName());
        skillSection.setSkillSectionDescription(skillSectionDto.getSkillSectionDescription());
        skillSection.setCategorySkillId(skillSectionDto.getCategorySkill());
        skillSection.setSkillSectionCreateAt(time);
        skillSection.setSkillSectionUpdateAt(time);
        skillSection.setSkillSectionDeleteAt(time);
        skillSection.setStatut(GStatutObj.ADD);

        return this.repo.save(skillSection);
    }

    @Override
    public SkillSection updateSkillSection(SkillSectionDto skillSectionDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        SkillSection existingSkillSection = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Skill section not found with id :"+objId));

        existingSkillSection.setSkillSectionCode(skillSectionDto.getSkillSectionCode());
        existingSkillSection.setSkillSectionName(skillSectionDto.getSkillSectionName());
        existingSkillSection.setSkillSectionDescription(skillSectionDto.getSkillSectionDescription());
        existingSkillSection.setCategorySkillId(skillSectionDto.getCategorySkill());
        existingSkillSection.setSkillSectionUpdateAt(time);
        existingSkillSection.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingSkillSection);
    }

    @Override
    public ResponseEntity<SkillSection> deleteSkillSection(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        SkillSection existingSkillSection = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Skill section not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingSkillSection);
        return ResponseEntity.ok().build();
    }
}
