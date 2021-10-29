package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.TypeEmploiDto;
import tn.gov.douane.formations.api.model.TypeEmploi;
import tn.gov.douane.formations.api.service.TypeEmploiServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/typemploi")
public class TypeEmploiControllerImpl implements TypeEmploiController {

    @Autowired
    private TypeEmploiServiceImpl service;

    public TypeEmploiControllerImpl (){ super();}

    public TypeEmploiControllerImpl(TypeEmploiServiceImpl service){
        super();
        this.service = service;
    }

    //get all TypeEmploi
    @GetMapping
    public List<TypeEmploi> getAllTypeEmploi() {
        return this.service.getAllTypeEmploi();
    }

    //get all TypeEmploi by id
    @GetMapping("/{id}")
    public TypeEmploi getTypeEmploiById(@PathVariable(value = "id") long objId) {
        return this.service.getTypeEmploiById(objId);
    }

    //get all TypeEmploi by label
    @GetMapping("/")
    @ResponseBody
    public TypeEmploi getTypeEmploiByLibelle(@RequestParam String libelle) {
        return this.service.getTypeEmploiByLibelle(libelle);
    }

    //create TypeEmploi
    @PostMapping
    public TypeEmploi createTypeEmploi(@RequestBody TypeEmploiDto typeEmploiDto) {
        return this.service.createTypeEmploi(typeEmploiDto);
    }

    //update TypeEmploi
    @PutMapping("/{id}")
    public TypeEmploi updateTypeEmploi(@RequestBody TypeEmploiDto typeEmploi,
                                       @PathVariable(value = "id") long objId) {
        return this.service.updateTypeEmploi(typeEmploi, objId);
    }

    //delete TypeEmploi
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeEmploi> deleteTypeEmploi(@PathVariable(value = "id") long objId) {
        return this.service.deleteTypeEmploi(objId);
    }
}
