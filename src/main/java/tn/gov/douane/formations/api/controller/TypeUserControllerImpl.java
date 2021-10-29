package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.TypeUserDto;
import tn.gov.douane.formations.api.model.TypeUser;
import tn.gov.douane.formations.api.service.TypeUserServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/typeuser")
public class TypeUserControllerImpl implements TypeUserController {

    @Autowired
    private TypeUserServiceImpl service;

    public TypeUserControllerImpl(){ super();}

    public TypeUserControllerImpl(TypeUserServiceImpl service){
        super();
        this.service = service;
    }
    //get All TypeUser
    @GetMapping
    public List<TypeUser> getAllTypeUser() {
        return this.service.getAllTypeUser();
    }

    //get All TypeUser by id
    @GetMapping("/{id}")
    public TypeUser getTypeUserById(@PathVariable(value = "id") long objId) {
        return this.service.getTypeUserById(objId);
    }

    //get All TypeUser by label
    @GetMapping("/libelle/{libelle}")
    public TypeUser getTypeUserByLibelle(@PathVariable(value = "libelle") String libelle) {
        return this.service.getTypeUserByLibelle(libelle);
    }

    //create TypeUser
    @PostMapping
    public TypeUser createTypeUser(@RequestBody TypeUserDto typeUserDto) {
        return this.service.createTypeUser(typeUserDto);
    }

    //update TypeUser
    @PutMapping("/{id}")
    public TypeUser updateTypeUser(@RequestBody TypeUserDto typeUserDto, @PathVariable(value = "id") long objId) {
        return this.service.updateTypeUser(typeUserDto, objId);
    }

    //delete TypeUser
    @DeleteMapping("/{id}")
    public ResponseEntity<TypeUser> deleteTypeUser(@PathVariable(value = "id") long objId) {
        return this.service.deleteTypeUser(objId);
    }
}
