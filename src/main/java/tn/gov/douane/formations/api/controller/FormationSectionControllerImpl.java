package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.FormationSectionDto;
import tn.gov.douane.formations.api.model.CategoryFormation;
import tn.gov.douane.formations.api.model.FormationSection;
import tn.gov.douane.formations.api.service.CategoryFormationServiceImpl;
import tn.gov.douane.formations.api.service.FormationSectionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/formationsection")
public class FormationSectionControllerImpl implements FormationSectionController {

    @Autowired
    private FormationSectionServiceImpl service;

    @Autowired
    private CategoryFormationServiceImpl serviceCategoryFormation;

    public FormationSectionControllerImpl () { super ();}

    public FormationSectionControllerImpl (FormationSectionServiceImpl service){
        super();
        this.service = service;
    }

    // get all FormationSection
    @GetMapping
    public List<FormationSection> getAllFormationSection() {
        return this.service.getAllFormationSection();
    }

    // get all FormationSection by id
    @GetMapping("/{id}")
    public FormationSection getFormationSectionById(@PathVariable("id") long objId) {
        return this.service.getFormationSectionById(objId);
    }

    // get all FormationSection by label
    @GetMapping("/")
    @ResponseBody
    public FormationSection getFormationSectionByCode(@RequestParam String code) {
        return this.service.getFormationSectionByCode(code);
    }

    // Create FormationSection
    @PostMapping
    public FormationSection createFormationSection(@RequestBody FormationSectionDto formationSectionDto) {

        CategoryFormation categoryFormation = serviceCategoryFormation.getCategoryFormationById(formationSectionDto.getCategoryFormationId());
        formationSectionDto.setCategoryFormation(categoryFormation);

        return this.service.createFormationSection(formationSectionDto);
    }

    //update FormationSection
    @PutMapping("/{id}")
    public FormationSection updateFormationSection(@RequestBody FormationSectionDto formationSectionDto,
                                                   @PathVariable(value = "id") long objId) {

        CategoryFormation categoryFormation = serviceCategoryFormation.getCategoryFormationById(formationSectionDto.getCategoryFormationId());
        formationSectionDto.setCategoryFormation(categoryFormation);

        return this.service.updateFormationSection(formationSectionDto, objId);
    }

    //delete FormationSEction by id
    @DeleteMapping("/{id}")
    public ResponseEntity<FormationSection> deleteFormationSection(@PathVariable(value = "id") long objId) {
        return this.service.deleteFormationSection(objId);
    }
}
