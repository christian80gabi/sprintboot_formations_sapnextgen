package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.CategorySkillDto;
import tn.gov.douane.formations.api.model.CategorySkill;
import tn.gov.douane.formations.api.service.CategorySkillServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/categoryskill")
public class CategorySkillControllerImpl implements CategorySkillController{

    @Autowired
    private CategorySkillServiceImpl service;

    public CategorySkillControllerImpl() {
        super();
    }

    public CategorySkillControllerImpl(CategorySkillServiceImpl service) {
        super();
        this.service = service;
    }

    //get all categoryskills
    @GetMapping
    public List<CategorySkill> getAllCategorySkill(){
        return this.service.getAllCategorySkill();
    }

    //get categoryskill by id
    @GetMapping("/{id}")
    public CategorySkill getCategorySkillById(@PathVariable(value = "id") long objId){
        return this.service.getCategorySkillById(objId);
    }

    @Override
    public CategorySkill getOneByName(@RequestParam String name) {
        return this.service.getOneByName(name);
    }

    //create categoryskill
    @PostMapping
    public CategorySkill createCategorySkill(@RequestBody CategorySkillDto categorySkill){
        return this.service.createCategorySkill(categorySkill);
    }

    //update categoryskill
    @PutMapping("/{id}")
    public CategorySkill updateCategorySkill(@RequestBody CategorySkillDto categorySkillDto,
                                             @PathVariable(value = "id") long objId){
        return this.service.updateCategorySkill(categorySkillDto, objId);
    }

    //delete categoryskill by id
    @DeleteMapping("/{id}")
    public ResponseEntity<CategorySkill> deleteCategorySkill(@PathVariable(value = "id") long objId){
        return this.service.deleteCategorySkill(objId);
    }
}
