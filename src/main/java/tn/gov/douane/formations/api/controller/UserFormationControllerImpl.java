package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserFormationDto;
import tn.gov.douane.formations.api.model.Formation;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserFormation;
import tn.gov.douane.formations.api.service.FormationServiceImpl;
import tn.gov.douane.formations.api.service.UserFormationServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/userformation")
public class UserFormationControllerImpl implements UserFormationController {

    @Autowired
    private UserFormationServiceImpl service;

    @Autowired
    private FormationServiceImpl serviceFormation;

    @Autowired
    private UserServiceImpl serviceUser;

    public UserFormationControllerImpl(){ super();}

    public UserFormationControllerImpl(UserFormationServiceImpl service){
        super();
        this.service = service;
    }

    //get all UserFormation
    @GetMapping
    public List<UserFormation> getAllUserFormation() {
        return this.service.getAllUserFormation();
    }

    //get all UserFormation by id
    @GetMapping("/{id}")
    public UserFormation getUserFormationById(@PathVariable(value = "id") long objId) {
        return this.service.getUserFormationById(objId);
    }

    //create UserFormation
    @PostMapping
    public UserFormation createUserFormation(@RequestBody UserFormationDto userFormationDto) {

        Formation formation = serviceFormation.getFormationById(userFormationDto.getFormationId());
        User user = serviceUser.getUserById(userFormationDto.getUserId());
        userFormationDto.setFormation(formation);
        userFormationDto.setUser(user);

        return this.service.createUserFormation(userFormationDto);
    }

    //update UserFormation
    @PutMapping("/{id}")
    public UserFormation updateUserFormation(@RequestBody UserFormationDto userFormationDto,
                                             @PathVariable(value = "id") long objId) {

        Formation formation = serviceFormation.getFormationById(userFormationDto.getFormationId());
        User user = serviceUser.getUserById(userFormationDto.getUserId());
        userFormationDto.setFormation(formation);
        userFormationDto.setUser(user);

        return this.service.updateUserFormation(userFormationDto, objId);
    }

    //delete UserFormation
    @DeleteMapping("/{id}")
    public ResponseEntity<UserFormation> deleteUserFormation(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserFormation(objId);
    }

    @GetMapping("user_formation_user/{userFormationUserId}")
    public List<Formation> getFormationsByUser(@PathVariable(value = "userFormationUserId") long userId) {
        return this.service.getFormationsByUser(userId);
    }

    @GetMapping("user_formation_formation/{userFormationFormationId}")
    public List<User> getUsersByFormation(@PathVariable(value = "userFormationFormationId") long formationId) {
        return this.service.getUsersByFormation(formationId);
    }
}
