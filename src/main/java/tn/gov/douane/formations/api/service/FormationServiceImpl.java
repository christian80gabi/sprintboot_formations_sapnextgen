package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.FormationDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Formation;
import tn.gov.douane.formations.api.repository.FormationRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository repo;

    public FormationServiceImpl() {
        super();
    }

    public FormationServiceImpl(FormationRepository repo) {
        super();
        this.repo = repo;
    }


    @Override
    public List<Formation> getAllFormation() {
        return this.repo.findAll();
    }

    @Override
    public Formation getFormationById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Formation not found with id :"+objId)
                );
    }

    @Override
    public Formation getFormationByLabel(String code) {

        return null;
    }

    @Override
    public Formation createFormation(FormationDto formationDto) {

        Timestamp time = GDate.precisionDateTime;
        Date periodStart = Date.valueOf(formationDto.getFormationPeriodStart());
        Date periodEnd = Date.valueOf(formationDto.getFormationPeriodEnd());

        Formation formation = new Formation();
        formation.setFormationCode(formationDto.getFormationCode());
        formation.setFormationName(formationDto.getFormationName());
        formation.setFormationDescription(formationDto.getFormationDescription());
        formation.setFormationDocument(formationDto.getFormationDocument());
        formation.setFormationLink(formationDto.getFormationLink());
        formation.setFormationPlace(formationDto.getFormationPlace());
        formation.setFormationQuota(formationDto.getFormationQuota());
        formation.setFormationResult(formationDto.getFormationResult());
        formation.setFormationPeriodStart(periodStart);
        formation.setFormationPeriodEnd(periodEnd);
        formation.setDomainStudyId(formationDto.getDomainStudy());
        formation.setFormationSectionId(formationDto.getFormationSection());
        formation.setFormationLevelId(formationDto.getLevelFormation());
        formation.setFormationCreateAt(time);
        formation.setFormationUpdateAt(time);
        formation.setFormationDeleteAt(time);
        formation.setStatut(GStatutObj.ADD);

        return this.repo.save(formation);
    }

    @Override
    public Formation updateFormation(FormationDto formationDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Date periodStart = Date.valueOf(formationDto.getFormationPeriodStart());
        Date periodEnd = Date.valueOf(formationDto.getFormationPeriodEnd());
        Formation existingFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Formation not found with id :"+objId));


        existingFormation.setFormationCode(formationDto.getFormationCode());
        existingFormation.setFormationName(formationDto.getFormationName());
        existingFormation.setFormationDescription(formationDto.getFormationDescription());
        existingFormation.setFormationDocument(formationDto.getFormationDocument());
        existingFormation.setFormationLink(formationDto.getFormationLink());
        existingFormation.setFormationPlace(formationDto.getFormationPlace());
        existingFormation.setFormationQuota(formationDto.getFormationQuota());
        existingFormation.setFormationResult(formationDto.getFormationResult());
        existingFormation.setFormationPeriodStart(periodStart);
        existingFormation.setFormationPeriodEnd(periodEnd);
        existingFormation.setDomainStudyId(formationDto.getDomainStudy());
        existingFormation.setFormationSectionId(formationDto.getFormationSection());
        existingFormation.setFormationLevelId(formationDto.getLevelFormation());
        existingFormation.setFormationUpdateAt(time);
        existingFormation.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingFormation);
    }

    @Override
    public ResponseEntity<Formation> deleteFormation(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Formation existingFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Formation not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingFormation);
        return ResponseEntity.ok().build();
    }
}
