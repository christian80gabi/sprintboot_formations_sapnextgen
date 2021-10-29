package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.ExperienceDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Experience;
import tn.gov.douane.formations.api.repository.ExperienceRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository repo;

    public ExperienceServiceImpl() {
        super();
    }

    public ExperienceServiceImpl(ExperienceRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Experience> getAllExperience() {
        return this.repo.findAll();
    }

    @Override
    public Experience getExperienceById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Experience not found with id :"+objId)
                );
    }

    @Override
    public Experience getExperienceByCode(String code) {

        List<Experience> experiences = repo.findAll();
        Experience resultat = null;

        for (Experience obj : experiences) {
            if (code.equalsIgnoreCase(obj.getExperienceCode())){
                resultat = new Experience(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public Experience createExperience(ExperienceDto experienceDto) {

        Timestamp time = GDate.precisionDateTime;
        Date expPeriodStart = Date.valueOf(experienceDto.getExpPeriodStart());
        Date expPeriodEnd = Date.valueOf(experienceDto.getExpPeriodEnd());
        Experience exp = new Experience();
        exp.setExperienceCode(experienceDto.getExpCode());
        exp.setExperienceName(experienceDto.getExpName());
        exp.setExperienceDescription(experienceDto.getExpDescription());
        exp.setExperienceDocument(experienceDto.getExpDocument());
        exp.setExperienceLink(experienceDto.getExpLink());
        exp.setExperiencePeriodStart(expPeriodStart);
        exp.setExperiencePeriodEnd(expPeriodEnd);
        exp.setExperiencePoint(experienceDto.getExpPoint());
        exp.setExperiencePlace(experienceDto.getExpPlace());
        exp.setLevelExperienceId(experienceDto.getLevelExp());
        exp.setTypeEmploiId(experienceDto.getTypeEmp());
        exp.setPosteId(experienceDto.getPoste());
        exp.setExperienceCreateAt(time);
        exp.setExperienceUpdateAt(time);
        exp.setExperienceDeleteAt(time);
        exp.setStatut(GStatutObj.ADD);

        return this.repo.save(exp);
    }

    @Override
    public Experience updateExperience(ExperienceDto experienceDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Experience existingExp = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Experience not found with id :"+objId));
        Date expPeriodStart = Date.valueOf(experienceDto.getExpPeriodStart());
        Date expPeriodEnd = Date.valueOf(experienceDto.getExpPeriodEnd());
        Experience exp = new Experience();
        existingExp.setExperienceCode(experienceDto.getExpCode());
        existingExp.setExperienceName(experienceDto.getExpName());
        existingExp.setExperienceDescription(experienceDto.getExpDescription());
        existingExp.setExperienceDocument(experienceDto.getExpDocument());
        existingExp.setExperienceLink(experienceDto.getExpLink());
        existingExp.setExperiencePeriodStart(expPeriodStart);
        existingExp.setExperiencePeriodEnd(expPeriodEnd);
        existingExp.setExperiencePoint(experienceDto.getExpPoint());
        existingExp.setExperiencePlace(experienceDto.getExpPlace());
        existingExp.setLevelExperienceId(experienceDto.getLevelExp());
        existingExp.setTypeEmploiId(experienceDto.getTypeEmp());
        existingExp.setPosteId(experienceDto.getPoste());
        existingExp.setExperienceUpdateAt(time);
        existingExp.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingExp);
    }

    @Override
    public ResponseEntity<Experience> deleteExperience(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Experience existingExperience = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Experience not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingExperience);

        return ResponseEntity.ok().build();
    }
}
