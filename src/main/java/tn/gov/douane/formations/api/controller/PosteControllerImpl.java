package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.PosteDto;
import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.PosteStatut;
import tn.gov.douane.formations.api.service.GradeServiceImpl;
import tn.gov.douane.formations.api.service.PosteServiceImpl;
import tn.gov.douane.formations.api.service.PosteStatutServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/poste")
public class PosteControllerImpl implements PosteController {

    @Autowired
    private PosteServiceImpl service;

    @Autowired
    private PosteStatutServiceImpl servicePosteStatut;

    @Autowired
    private GradeServiceImpl serviceGrade;

    public PosteControllerImpl(){
        super();
    }

    public PosteControllerImpl(PosteServiceImpl service){
        super();
        this.service = service;
    }

    //get all poste
    @GetMapping
    @Override
    public List<Poste> getAllPoste() {
        return this.service.getAllPoste();
    }

    //get poste by id
    @GetMapping("/{id}")
    public Poste getPosteById(@PathVariable(value = "id") long objId){
        return this.service.getPosteById(objId);
    }

    //get all poste by code
    @GetMapping("/pc")
    @ResponseBody
    public Poste getPosteByCode(@RequestParam String code) {
        return this.service.getPosteByCode(code);
    }

    //get all poste by label
    @GetMapping("/pl")
    @ResponseBody
    public Poste getPosteByLabel(@RequestParam String label) {
        return this.service.getPosteByLabel(label);
    }

    @GetMapping("/")
    @ResponseBody
    public List<Poste> getPosteByPreviousPoste(@RequestParam long previousPosteId) {
        return this.service.getPosteByPreviousPoste(previousPosteId);
    }

    //create poste
    @PostMapping
    public Poste createPoste(@RequestBody PosteDto posteDto) {

        PosteStatut posteStatut = servicePosteStatut.getPosteStatutById(posteDto.getPosteStatutId());
        Grade grade = serviceGrade.getGradeById(posteDto.getGradeId());
        posteDto.setPosteStatut(posteStatut);
        posteDto.setGrade(grade);

        return this.service.createPoste(posteDto);
    }

    //update poste
    @PutMapping("/{id}")
    public Poste updatePoste(@RequestBody PosteDto posteDto,
                             @PathVariable(value = "id") long objId) {

        PosteStatut posteStatut = servicePosteStatut.getPosteStatutById(posteDto.getPosteStatutId());
        Grade grade = serviceGrade.getGradeById(posteDto.getGradeId());
        posteDto.setPosteStatut(posteStatut);
        posteDto.setGrade(grade);

        return this.service.updatePoste(posteDto, objId);
    }

    //delete poste
    @DeleteMapping("/{id}")
    public ResponseEntity<Poste> deletePoste(@PathVariable(value = "id") long objId) {

        return this.service.deletePoste(objId);
    }
}
