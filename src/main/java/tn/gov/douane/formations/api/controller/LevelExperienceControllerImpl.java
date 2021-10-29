package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.LevelExperienceDto;
import tn.gov.douane.formations.api.model.LevelExperience;
import tn.gov.douane.formations.api.service.LevelExperienceServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/levelexperience")
public class LevelExperienceControllerImpl implements LevelExperienceController {

    @Autowired
    private LevelExperienceServiceImpl service;

    public LevelExperienceControllerImpl(){ super();}

    public LevelExperienceControllerImpl(LevelExperienceServiceImpl service){
        super();
        this.service = service;
    }

    //get all LevelExperience
    @GetMapping
    public List<LevelExperience> getAllLevelExperience() {
        return this.service.getAllLevelExperience();
    }

    //get all LevelExperience by id
    @GetMapping("/{id}")
    public LevelExperience getLevelExperienceById(@PathVariable(value = "id") long objId) {
        return this.service.getLevelExperienceById(objId);
    }

    //get all LevelExperience by label
    @GetMapping("/")
    @ResponseBody
    public LevelExperience getLevelExperienceByCode(@RequestParam String code) {
        return this.service.getLevelExperienceByCode(code);
    }

    //create LevelExperience
    @PostMapping
    public LevelExperience createLevelExperience(@RequestBody LevelExperienceDto levelExperience) {
        return this.service.createLevelExperience(levelExperience);
    }

    //update LevelExperience
    @PutMapping("/{id}")
    public LevelExperience updateLevelExperience(@RequestBody LevelExperienceDto levelExperience,
                                                 @PathVariable(value = "id") long objId) {
        return this.service.updateLevelExperience(levelExperience, objId);
    }

    //delete LevelExperience
    @DeleteMapping("/{id}")
    public ResponseEntity<LevelExperience> deleteLevelExperience(@PathVariable(value = "id") long objId) {
        return this.service.deleteLevelExperience(objId);
    }
}
