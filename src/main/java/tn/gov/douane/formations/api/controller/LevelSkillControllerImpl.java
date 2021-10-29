package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.LevelSkillDto;
import tn.gov.douane.formations.api.model.LevelSkill;
import tn.gov.douane.formations.api.service.LevelSkillServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/levelskill")
public class LevelSkillControllerImpl implements LevelSkillController {

    @Autowired
    private LevelSkillServiceImpl service;

    public LevelSkillControllerImpl(){ super();}

    public LevelSkillControllerImpl(LevelSkillServiceImpl service) {
        super();
        this.service = service;
    }
    //get all levelSkill
    @GetMapping
    public List<LevelSkill> getAllLevelSkill() {
        return this.service.getAllLevelSkill();
    }

    //get all levelSkill by id
    @GetMapping("/{id}")
    public LevelSkill getLevelSkillById(@PathVariable(value = "id") long objId) {
        return this.service.getLevelSkillById(objId);
    }

    //get all levelSkill by label
    @GetMapping("/")
    @ResponseBody
    public LevelSkill getLevelSkillByCode(@RequestParam String code) {
        return this.service.getLevelSkillByCode(code);
    }

    //create levelSkill
    @PostMapping
    public LevelSkill createLevelSkill(@RequestBody LevelSkillDto levelSkillDto) {
        return this.service.createLevelSkill(levelSkillDto);
    }

    //update levelSkill
    @PutMapping("/{id}")
    public LevelSkill updateLevelSkill(@RequestBody LevelSkillDto levelSkillDto, @PathVariable(value = "id") long objId) {
        return this.service.updateLevelSkill(levelSkillDto, objId);
    }

    //delete levelSkill
    @DeleteMapping("/{id}")
    public ResponseEntity<LevelSkill> deleteLevelSkill(@PathVariable(value = "id") long objId) {
        return this.service.deleteLevelSkill(objId);
    }
}


