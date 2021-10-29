package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.SkillDto;
import tn.gov.douane.formations.api.model.LevelSkill;
import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.model.SkillSection;
import tn.gov.douane.formations.api.service.LevelSkillServiceImpl;
import tn.gov.douane.formations.api.service.SkillSectionServiceImpl;
import tn.gov.douane.formations.api.service.SkillServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillControllerImpl implements SkillController {

    @Autowired
    private SkillServiceImpl service;

    @Autowired
    private SkillSectionServiceImpl serviceSkillSection;

    @Autowired
    private LevelSkillServiceImpl serviceLevelSkill;

    public SkillControllerImpl(){ super();}

    public SkillControllerImpl(SkillServiceImpl service){
        super();
        this.service = service;
    }

    //get all Skill
    @GetMapping
    public List<Skill> getAllSkill() {
        return this.service.getAllSkill();
    }

    //get all Skill by id
    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable(value = "id") long objId) {
        return this.service.getSkillById(objId);
    }

    //get all Skill by label
    @GetMapping("/")
    @ResponseBody
    public Skill getSkillByCode(@RequestParam String code) {
        return this.service.getSkillByCode(code);
    }

    //create Skill
    @PostMapping
    public Skill createSkill(@RequestBody SkillDto skillDto) {

        SkillSection skillSection = serviceSkillSection.getSkillSectionById(skillDto.getSkillSectionId());
        LevelSkill levelSkill = serviceLevelSkill.getLevelSkillById(skillDto.getLevelSkillId());
        skillDto.setSkillSection(skillSection);
        skillDto.setLevelSkill(levelSkill);

        return this.service.createSkill(skillDto);
    }

    //update Skill
    @PutMapping("/{id}")
    public Skill updateSkill(@RequestBody SkillDto skillDto, @PathVariable(value = "id") long objId) {

        SkillSection skillSection = serviceSkillSection.getSkillSectionById(skillDto.getSkillSectionId());
        LevelSkill levelSkill = serviceLevelSkill.getLevelSkillById(skillDto.getLevelSkillId());
        skillDto.setSkillSection(skillSection);
        skillDto.setLevelSkill(levelSkill);

        return this.service.updateSkill(skillDto, objId);
    }

    //delete Skill
    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> deleteSkill(@PathVariable(value = "id") long objId) {
        return this.service.deleteSkill(objId);
    }
}
