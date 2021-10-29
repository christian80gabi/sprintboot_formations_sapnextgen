package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.PosteStatutDto;
import tn.gov.douane.formations.api.model.PosteStatut;
import tn.gov.douane.formations.api.service.PosteStatutServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/postestatut")
public class PosteStatutControllerImpl implements PosteStatutController{

    @Autowired
    private PosteStatutServiceImpl service;

    public PosteStatutControllerImpl() {
        super();
    }

    public PosteStatutControllerImpl(PosteStatutServiceImpl service) {
        super();
        this.service = service;
    }

    //get all postestatuts
    @GetMapping
    @Override
    public List<PosteStatut> getAllPosteStatut() {
        return this.service.getAllPosteStatut();
    }

    //get postestatut by id
    @GetMapping("/{id}")
    @Override
    public PosteStatut getPosteStatutById(@PathVariable(value = "id") long objId) {
        return this.service.getPosteStatutById(objId);
    }

    //get postestatut by label
    @Override
    public PosteStatut getPosteStatutByLabel(@RequestParam PosteStatutDto posteStatutDto) {
        return this.service.getPosteStatutByLabel(posteStatutDto);
    }

    //create postestatut
    @PostMapping
    @Override
    public PosteStatut createPosteStatut(@RequestBody PosteStatutDto posteStatutDto) {
        return this.service.createPosteStatut(posteStatutDto);
    }

    //update postestatut
    @PutMapping("/{id}")
    @Override
    public PosteStatut updatePosteStatut(@RequestBody PosteStatutDto posteStatutDto, @PathVariable(value = "id") long objId) {
        return this.service.updatePosteStatut(posteStatutDto, objId);
    }

    //delete postestatut by id
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<PosteStatut> deletePosteStatut(@PathVariable(value = "id") long objId) {
        return this.service.deletePosteStatut(objId);
    }
}
