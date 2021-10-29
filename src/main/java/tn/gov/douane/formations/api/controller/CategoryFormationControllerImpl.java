package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.CategoryFormationDto;
import tn.gov.douane.formations.api.model.CategoryFormation;
import tn.gov.douane.formations.api.service.CategoryFormationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/categoryformation")
public class CategoryFormationControllerImpl implements CategoryFormationController {

    @Autowired
    private CategoryFormationServiceImpl service;

    public CategoryFormationControllerImpl () { super();}

    public CategoryFormationControllerImpl (CategoryFormationServiceImpl service) {
        super();
        this.service = service;
    }

   //get all CategoryFormation
    @GetMapping
    public List<CategoryFormation> getAllCategoryFormation() {
        return this.service.getAllCategoryFormation();
    }

    //get all CategoryFormation by id
    @GetMapping("/{id}")
    public CategoryFormation getCategoryFormationById(@PathVariable(value = "id") long objId) {
        return this.service.getCategoryFormationById(objId);
    }

    //get CategoryFormation by label
    @GetMapping("/")
    @ResponseBody
    public CategoryFormation getCategoryFormationByLabel(@RequestParam String code) {
        return this.service.getCategoryFormationByLabel(code);
    }

    //create CategoryFormation
    @PostMapping
    public CategoryFormation createCategoryFormation(@RequestBody CategoryFormationDto categoryFormationDto) {
        return this.service.createCategoryFormation(categoryFormationDto);
    }

    //update CategoryFormation
    @PutMapping("/{id}")
    public CategoryFormation updateCategoryFormation(@RequestBody CategoryFormationDto categoryFormationDto,
                                                     @PathVariable(value = "id") long objId) {
        return this.service.updateCategoryFormation(categoryFormationDto, objId);
    }

    //delete CategoryFormation by id
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryFormation> deleteCategoryFormation(@PathVariable(value = "id") long objId) {
        return this.service.deleteCategoryFormation(objId);
    }
}
