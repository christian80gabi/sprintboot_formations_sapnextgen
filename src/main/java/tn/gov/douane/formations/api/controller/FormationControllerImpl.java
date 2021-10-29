package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.FormationDto;
import tn.gov.douane.formations.api.model.DomainStudy;
import tn.gov.douane.formations.api.model.Formation;
import tn.gov.douane.formations.api.model.FormationSection;
import tn.gov.douane.formations.api.model.LevelFormation;
import tn.gov.douane.formations.api.service.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationControllerImpl implements FormationService {

    @Autowired
    private FormationServiceImpl service;

    @Autowired
    private DomainStudyServiceImpl serviceDomainStudy;

    @Autowired
    private FormationSectionServiceImpl serviceFormationSection;

    @Autowired
    private LevelFormationServiceImpl serviceLevelFormation;


    public FormationControllerImpl(){ super();}


    public FormationControllerImpl(FormationServiceImpl service){
        super();
        this.service = service;
    }

    //get all Formation
    @GetMapping
    public List<Formation> getAllFormation() {
        return this.service.getAllFormation();
    }

    //get all Formation by id
    @GetMapping("/{id}")
    public Formation getFormationById(@PathVariable(value = "id") long objId) {
        return this.service.getFormationById(objId);
    }

    //get all Formation by label
    @GetMapping("/")
    @ResponseBody
    public Formation getFormationByLabel(@RequestParam String code) {
        return this.service.getFormationByLabel(code);
    }

    //create Formation
    @PostMapping
    public Formation createFormation(@RequestBody FormationDto formationDto) {

        DomainStudy domainStudy = serviceDomainStudy.getDomainStudyById(formationDto.getDomainStudyId());
        FormationSection formationSection = serviceFormationSection.getFormationSectionById(formationDto.getFormationSectionId());
        LevelFormation levelFormation = serviceLevelFormation.getLevelFormationById(formationDto.getLevelFormationId());
        formationDto.setDomainStudy(domainStudy);
        formationDto.setFormationSection(formationSection);
        formationDto.setLevelFormation(levelFormation);

        return this.service.createFormation(formationDto);
    }

    //update Formation
    @PutMapping("/{id}")
    public Formation updateFormation(@RequestBody FormationDto formationDto,
                                     @PathVariable(value = "id") long objId) {

        DomainStudy domainStudy = serviceDomainStudy.getDomainStudyById(formationDto.getDomainStudyId());
        FormationSection formationSection = serviceFormationSection.getFormationSectionById(formationDto.getFormationSectionId());
        LevelFormation levelFormation = serviceLevelFormation.getLevelFormationById(formationDto.getLevelFormationId());
        formationDto.setDomainStudy(domainStudy);
        formationDto.setFormationSection(formationSection);
        formationDto.setLevelFormation(levelFormation);

        return this.service.updateFormation(formationDto, objId);
    }

    //delete formation by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Formation> deleteFormation(@PathVariable(value = "id") long objId) {
        return this.service.deleteFormation(objId);
    }
}
