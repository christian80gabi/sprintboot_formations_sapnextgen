package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.GradeDto;
import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.service.GradeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeControllerImpl implements GradeController {

    @Autowired
    private GradeServiceImpl service;

    public GradeControllerImpl(){ super();}

    public GradeControllerImpl(GradeServiceImpl service){
        super();
        this.service = service;
    }

   //get all Grade
    @GetMapping
    public List<Grade> getAllGrade() {
        return this.service.getAllGrade();
    }

    //get all Grade by id
    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable(value = "id") long objId) {
        return this.service.getGradeById(objId);
    }

    //get all Grade by label
    @GetMapping("/")
    @ResponseBody
    public Grade getGradeByLabel(@RequestParam String code) {
        return this.service.getGradeByLabel(code);
    }

    //create grade
    @PostMapping
    public Grade createGrade(@RequestBody GradeDto gradeDto) {
        return this.service.createGrade(gradeDto);
    }

    //update grade
    @PutMapping("/{id}")
    public Grade updateGrade(@RequestBody GradeDto gradeDto, @PathVariable(value = "id") long objId) {
        return this.service.updateGrade(gradeDto, objId);
    }

   //delete grade
    @DeleteMapping("/{id}")
    public ResponseEntity<Grade> deleteGrade(@PathVariable(value = "id") long objId) {
        return this.service.deleteGrade(objId);
    }
}
