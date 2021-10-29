package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserPosteDto;
import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserPoste;
import tn.gov.douane.formations.api.service.PosteServiceImpl;
import tn.gov.douane.formations.api.service.UserPosteServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/userposte")
public class UserPosteControllerImpl implements UserPosteController{

    @Autowired
    private UserPosteServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    @Autowired
    private PosteServiceImpl servicePoste;

    public UserPosteControllerImpl() {
        super();
    }

    public UserPosteControllerImpl(UserPosteServiceImpl service) {
        super();
        this.service = service;
    }

    @GetMapping
    @Override
    public List<UserPoste> getAllUserPoste() {
        return this.service.getAllUserPoste();
    }

    @GetMapping("/{id}")
    @Override
    public UserPoste getUserPosteById(@PathVariable(value = "id") long objId) {
        return this.service.getUserPosteById(objId);
    }

    @PostMapping
    @Override
    public UserPoste createUserPoste(@RequestBody UserPosteDto userPosteDto) {

        User user = serviceUser.getUserById(userPosteDto.getUserId());
        Poste poste = servicePoste.getPosteById(userPosteDto.getPosteId());
        userPosteDto.setUser(user);
        userPosteDto.setPoste(poste);

        return this.service.createUserPoste(userPosteDto);
    }

    @PutMapping("/{id}")
    @Override
    public UserPoste updateUserPoste(@RequestBody UserPosteDto userPosteDto, @PathVariable(value = "id") long objId) {

        User user = serviceUser.getUserById(userPosteDto.getUserId());
        Poste poste = servicePoste.getPosteById(userPosteDto.getPosteId());
        userPosteDto.setUser(user);
        userPosteDto.setPoste(poste);

        return this.service.updateUserPoste(userPosteDto, objId);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<UserPoste> deleteUserPoste(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserPoste(objId);
    }

    @GetMapping("user_poste_user/{userPosteUserId}")
    @Override
    public List<Poste> getPostesByUser(@PathVariable(value = "userPosteUserId") long userId) {
        return this.service.getPostesByUser(userId);
    }

    @GetMapping("user_poste_poste/{userPostePosteId}")
    @Override
    public List<User> getUsersByPoste(@PathVariable(value = "userPostePosteId") long posteId) {
        return this.service.getUsersByPoste(posteId);
    }
}
