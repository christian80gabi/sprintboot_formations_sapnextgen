package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.LevelFormationDto;
import tn.gov.douane.formations.api.model.LevelFormation;
import tn.gov.douane.formations.api.service.LevelFormationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/levelformation")
public class LevelFormationControllerImpl implements LevelFormationController {

    @Autowired
    private LevelFormationServiceImpl service;

    public LevelFormationControllerImpl (){ super();}

    public LevelFormationControllerImpl(LevelFormationServiceImpl service){
        super();
        this.service = service;
    }


   //get all LevelFormation
    @GetMapping
    public List<LevelFormation> getAllLevelFormation() {
        return this.service.getAllLevelFormation();
    }

    //get all LevelFormation by id
    @GetMapping("/{id}")
    public LevelFormation getLevelFormationById(@PathVariable(value = "id") long objId) {
        return this.service.getLevelFormationById(objId);
    }

    //get LevelFormation by label
    @GetMapping("/")
    @ResponseBody
    public LevelFormation getLevelFormationByLabel(@RequestParam String code) {
        return this.service.getLevelFormationByLabel(code);
    }

    //create LevelFormation
    @PostMapping
    public LevelFormation createLevelFormation(@RequestBody LevelFormationDto levelFormationDto) {
        return this.service.createLevelFormation(levelFormationDto);
    }

    //update LevelFormation
    @PutMapping("/{id}")
    public LevelFormation updateLevelFormation(@RequestBody LevelFormationDto levelFormationDto,
                                               @PathVariable(value = "id") long objId) {
        return this.service.updateLevelFormation(levelFormationDto, objId);
    }

    //delete LevelFormation
    @DeleteMapping("/{id}")
    public ResponseEntity<LevelFormation> deleteLevelFormation(@PathVariable(value = "id") long objId) {
        return null;
    }
}
