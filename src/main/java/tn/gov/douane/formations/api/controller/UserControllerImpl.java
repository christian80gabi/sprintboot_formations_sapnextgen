package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.model.TypeUser;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.service.TypeUserServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private TypeUserServiceImpl servicetypeUser;

    public UserControllerImpl(){ super();}

    public UserControllerImpl(UserServiceImpl service){
        super();
        this.service = service;
    }

    //get all User
    @GetMapping
    public List<User> getAllUser() {
        return this.service.getAllUser();
    }

   //get all User by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long objId) {
        return this.service.getUserById(objId);
    }

    //create User
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {

        TypeUser typeUser = servicetypeUser.getTypeUserById(userDto.getTypeUserId());
        userDto.setTypeUser(typeUser);

        return this.service.createUser(userDto);
    }

    //update User
    @PutMapping("/{id}")
    public User updateUser(@RequestBody UserDto userDto,
                           @PathVariable(value = "id") long objId) {

        TypeUser typeUser = servicetypeUser.getTypeUserById(userDto.getTypeUserId());
        userDto.setTypeUser(typeUser);

        return this.service.updateUser(userDto, objId);
    }

    //delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") long objId) {
        return this.service.deleteUser(objId);
    }

    @GetMapping("/matricule/{matricule}")
    @ResponseBody
    public User getUserByMatricule(@PathVariable(value = "matricule") String matricule) {
        return this.service.getUserByMatricule(matricule);
    }

    @GetMapping("/email/{email}")
    @ResponseBody
    public User getUserByEmail(@PathVariable(value = "email") String email) {
        return this.service.getUserByEmail(email);
    }

    @GetMapping("/username_password/{username}/{password}")
    @ResponseBody
    public User getUserByUsernamePassword(@PathVariable(value = "username") String username,
                                          @PathVariable(value = "password") String password) {
        return this.service.getUserByUsernamePassword(username, password);
    }
}
