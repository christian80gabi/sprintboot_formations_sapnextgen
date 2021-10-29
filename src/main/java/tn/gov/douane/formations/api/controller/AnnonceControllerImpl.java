package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.AnnonceDto;
import tn.gov.douane.formations.api.model.Annonce;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.service.AnnonceServiceImpl;
import tn.gov.douane.formations.api.service.PosteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceControllerImpl implements AnnonceController{

     @Autowired
     private AnnonceServiceImpl service;

     @Autowired
     private PosteServiceImpl servicePoste;

     public AnnonceControllerImpl () { super();}

     public AnnonceControllerImpl(AnnonceServiceImpl service) {
        super();
        this.service = service;
     }

    //get all annonce
    @GetMapping
    public List<Annonce> getAllAnnonce() {
        return this.service.getAllAnnonce();
    }

    //get annonce by id
    @GetMapping("/{id}")
    public Annonce getAnnonceById(@PathVariable(value = "id") long objId) {
        return this.service.getAnnonceById(objId);
    }

    //get annonce by label

    public Annonce getAnnonceByLabel(@RequestParam AnnonceDto annonceDto) {
         return this.service.getAnnonceByLabel(annonceDto);
    }

    //create annonce
    @PostMapping
    public Annonce createAnnonce(@RequestBody AnnonceDto annonceDto) {

         Poste poste = servicePoste.getPosteById(annonceDto.getPosteId());
         annonceDto.setPoste(poste);

         return this.service.createAnnonce(annonceDto);
    }

    //update annonce
    @PutMapping("/{id}")
    public Annonce updateAnnonce(@RequestBody AnnonceDto annonceDto,
                                 @PathVariable(value = "id") long objId) {

        Poste poste = servicePoste.getPosteById(annonceDto.getPosteId());
        annonceDto.setPoste(poste);

        return this.service.updateAnnonce(annonceDto, objId);
    }

    //delete annonce by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Annonce> deleteAnnonce(@PathVariable(value = "id") long objId) {
        return this.service.deleteAnnonce(objId);
    }
}
