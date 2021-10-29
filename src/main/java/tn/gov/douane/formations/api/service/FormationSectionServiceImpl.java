package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.FormationSectionDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.FormationSection;
import tn.gov.douane.formations.api.repository.CategoryFormationRepository;
import tn.gov.douane.formations.api.repository.FormationSectionRepository;

import java.sql.Timestamp;
import java.util.List;

@Service
public class FormationSectionServiceImpl implements FormationSectionService {

    @Autowired
    private FormationSectionRepository repo;

    @Autowired
    private CategoryFormationRepository repoCategoryFormation;

    public FormationSectionServiceImpl() {
        super();
    }

    public FormationSectionServiceImpl(FormationSectionRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<FormationSection> getAllFormationSection() { return repo.findAll(); }

    @Override
    public FormationSection getFormationSectionById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Formation section not found with id :"+objId)
                );
    }

    @Override
    public FormationSection getFormationSectionByCode(String code) {

        List<FormationSection> formationSections = repo.findAll();
        FormationSection resultat = null;

        for (FormationSection obj : formationSections) {
            if (code.equalsIgnoreCase(obj.getFormationSectionCode())){
                resultat = new FormationSection(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public FormationSection createFormationSection(FormationSectionDto formationSectionDto) {

        Timestamp time = GDate.precisionDateTime;
        FormationSection formationSection = new FormationSection();
        formationSection.setFormationSectionCode(formationSectionDto.getFormationSectionCode());
        formationSection.setFormationSectionName(formationSectionDto.getFormationSectionName());
        formationSection.setFormationSectionDescription(formationSectionDto.getFormationSectionDescription());
        formationSection.setCategoryFormationId(formationSectionDto.getCategoryFormation());
        formationSection.setFormationSectionCreateAt(time);
        formationSection.setFormationSectionUpdateAt(time);
        formationSection.setFormationSectionDeleteAt(time);
        formationSection.setStatut(GStatutObj.ADD);

        return this.repo.save(formationSection);

    }

    @Override
    public FormationSection updateFormationSection(FormationSectionDto formationSectionDto, long objId) {

        Timestamp time = GDate.precisionDateTime;

        FormationSection existingFormationSection = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Formation section not found with id :"+objId));

        existingFormationSection.setFormationSectionCode(formationSectionDto.getFormationSectionCode());
        existingFormationSection.setFormationSectionName(formationSectionDto.getFormationSectionName());
        existingFormationSection.setFormationSectionDescription(formationSectionDto.getFormationSectionDescription());
        existingFormationSection.setCategoryFormationId(formationSectionDto.getCategoryFormation());
        existingFormationSection.setFormationSectionUpdateAt(time);
        existingFormationSection.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingFormationSection);
    }

    @Override
    public ResponseEntity<FormationSection> deleteFormationSection(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        FormationSection existingFormationSection = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Formation section not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingFormationSection);
        return ResponseEntity.ok().build();
    }
}
