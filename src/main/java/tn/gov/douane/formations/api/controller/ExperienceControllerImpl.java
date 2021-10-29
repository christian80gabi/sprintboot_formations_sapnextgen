package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.ExperienceDto;
import tn.gov.douane.formations.api.model.Experience;
import tn.gov.douane.formations.api.model.LevelExperience;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.TypeEmploi;
import tn.gov.douane.formations.api.service.ExperienceServiceImpl;
import tn.gov.douane.formations.api.service.LevelExperienceServiceImpl;
import tn.gov.douane.formations.api.service.PosteServiceImpl;
import tn.gov.douane.formations.api.service.TypeEmploiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceControllerImpl implements ExperienceController {

    @Autowired
    private ExperienceServiceImpl service;

    @Autowired
    private LevelExperienceServiceImpl serviceLevelExp;

    @Autowired
    private TypeEmploiServiceImpl serviceTypeEmploi;

    @Autowired
    private PosteServiceImpl servicePoste;

    public ExperienceControllerImpl(){ super();}

    public ExperienceControllerImpl(ExperienceServiceImpl service){
        super();
        this.service = service;
    }

    //get all Experience
    @GetMapping
    public List<Experience> getAllExperience() {
        return this.service.getAllExperience();
    }

    //get all Experience by id
    @GetMapping("/{id}")
    public Experience getExperienceById(@PathVariable(value = "id") long objId) {
        return this.service.getExperienceById(objId);
    }

    //get all Experience by code
    @GetMapping("/")
    @ResponseBody
    public Experience getExperienceByCode(@RequestParam String code) {
        return this.service.getExperienceByCode(code);
    }

    //create Experience
    @PostMapping
    public Experience createExperience(@RequestBody ExperienceDto experienceDto) {

        LevelExperience levelExperience = serviceLevelExp.getLevelExperienceById(experienceDto.getLevelExpId());
        TypeEmploi typeEmploi = serviceTypeEmploi.getTypeEmploiById(experienceDto.getTypeEmpId());
        Poste poste = servicePoste.getPosteById(experienceDto.getPosteId());
        experienceDto.setLevelExp(levelExperience);
        experienceDto.setTypeEmp(typeEmploi);
        experienceDto.setPoste(poste);

        return this.service.createExperience(experienceDto);
    }

    //update Experience
    @PutMapping("/{id}")
    public Experience updateExperience(@RequestBody ExperienceDto experienceDto,
                                       @PathVariable(value = "id") long objId) {

        LevelExperience levelExperience = serviceLevelExp.getLevelExperienceById(experienceDto.getLevelExpId());
        TypeEmploi typeEmploi = serviceTypeEmploi.getTypeEmploiById(experienceDto.getTypeEmpId());
        Poste poste = servicePoste.getPosteById(experienceDto.getPosteId());
        experienceDto.setLevelExp(levelExperience);
        experienceDto.setTypeEmp(typeEmploi);
        experienceDto.setPoste(poste);

        return this.service.updateExperience(experienceDto, objId);
    }

    //delete experience by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Experience> deleteExperience(@PathVariable(value = "id") long objId) {
        return this.service.deleteExperience(objId);
    }
}
