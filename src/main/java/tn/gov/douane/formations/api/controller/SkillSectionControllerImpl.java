package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.SkillSectionDto;
import tn.gov.douane.formations.api.model.CategorySkill;
import tn.gov.douane.formations.api.model.SkillSection;
import tn.gov.douane.formations.api.service.CategorySkillServiceImpl;
import tn.gov.douane.formations.api.service.SkillSectionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/skillsection")
public class SkillSectionControllerImpl implements SkillSectionController {

    @Autowired
    private SkillSectionServiceImpl service;

    @Autowired
    private CategorySkillServiceImpl serviceCategorySkill;

    public SkillSectionControllerImpl(){ super();}

    public SkillSectionControllerImpl(SkillSectionServiceImpl service){
        super();
        this.service= service;
    }

    //get all SkillSection
    @GetMapping
    public List<SkillSection> getAllSkillSection() {
        return this.service.getAllSkillSection();
    }

    //get all SkillSection by id
    @GetMapping("/{id}")
    public SkillSection getSkillSectionById(@PathVariable(value = "id") long objId) {
        return this.service.getSkillSectionById(objId);
    }

    //get SkillSection by code
    @GetMapping("/")
    @ResponseBody
    public SkillSection getSkillByCode(@RequestParam String code) {
        return this.service.getSkillByCode(code);
    }

    //create SkillSection
    @PostMapping
    public SkillSection createSkillSection(@RequestBody SkillSectionDto skillSectionDto) {

        CategorySkill categorySkill = serviceCategorySkill.getCategorySkillById(skillSectionDto.getCategorySkillId());
        skillSectionDto.setCategorySkill(categorySkill);

        return this.service.createSkillSection(skillSectionDto);
    }

    //update SkillSection
    @PutMapping("/{id}")
    public SkillSection updateSkillSection(@RequestBody SkillSectionDto skillSectionDto,
                                           @PathVariable(value = "id") long objId) {

        CategorySkill categorySkill = serviceCategorySkill.getCategorySkillById(skillSectionDto.getCategorySkillId());
        skillSectionDto.setCategorySkill(categorySkill);

        return this.service.updateSkillSection(skillSectionDto, objId);
    }
    //delete SkillSection
    @DeleteMapping("/{id}")
    public ResponseEntity<SkillSection> deleteSkillSection(@PathVariable(value = "id") long objId) {
        return this.service.deleteSkillSection(objId);
    }
}
