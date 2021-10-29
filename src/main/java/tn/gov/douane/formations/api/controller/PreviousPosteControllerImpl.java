package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.PreviousPosteDto;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.PreviousPoste;
import tn.gov.douane.formations.api.service.PosteServiceImpl;
import tn.gov.douane.formations.api.service.PreviousPosteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/previousposte")
public class PreviousPosteControllerImpl implements PreviousPosteController {

    @Autowired
    private PreviousPosteServiceImpl service;

    @Autowired
    private PosteServiceImpl servicePoste;

    public PreviousPosteControllerImpl(){ super();}

    public PreviousPosteControllerImpl(PreviousPosteServiceImpl service ){
        super();
        this.service= service;
    }

    //get all PreviousPoste
    @GetMapping
    public List<PreviousPoste> getAllPreviousPoste() {
        return this.service.getAllPreviousPoste();
    }

    //get all PreviousPoste by id
    @GetMapping("/{id}")
    public PreviousPoste getPreviousPosteById(@PathVariable(value = "id") long objId) {
        return this.service.getPreviousPosteById(objId);
    }

    //get all PreviousPoste by label
    @GetMapping("/")
    @ResponseBody
    public List<Poste> getPreviousPosteByPoste(@RequestParam long posteId) {
        return this.service.getPreviousPosteByPoste(posteId);
    }

    //create PreviousPoste
    @PostMapping
    public PreviousPoste createPreviousPoste(@RequestBody PreviousPosteDto previousPosteDto) {

        Poste previousPoste = servicePoste.getPosteById(previousPosteDto.getPostePreviousId());
        Poste poste = servicePoste.getPosteById(previousPosteDto.getPosteId());
        previousPosteDto.setPreviousPoste(previousPoste);
        previousPosteDto.setPoste(poste);

        return this.service.createPreviousPoste(previousPosteDto);
    }

    //update PreviousPoste
    @PutMapping("/{id}")
    public PreviousPoste updatePreviousPoste(@RequestBody PreviousPosteDto previousPoste,
                                             @PathVariable(value = "id") long objId) {
        return this.service.updatePreviousPoste(previousPoste, objId);
    }

    //delete PreviousPoste
    @DeleteMapping("/{id}")
    public ResponseEntity<PreviousPoste> deletePreviousPoste(@PathVariable(value = "id") long objId) {
        return this.service.deletePreviousPoste(objId);
    }
}
