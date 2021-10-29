package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserRoleDto;
import tn.gov.douane.formations.api.model.Role;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserRole;
import tn.gov.douane.formations.api.service.RoleServiceImpl;
import tn.gov.douane.formations.api.service.UserRoleServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/userole")
public class UserRoleControllerImpl implements UserRoleController {

    @Autowired
    private UserRoleServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    @Autowired
    private RoleServiceImpl serviceRole;

    public UserRoleControllerImpl(){ super();}

    public UserRoleControllerImpl(UserRoleServiceImpl service){
        super();
        this.service = service;

    }
    //get all UserRole
    @GetMapping
    public List<UserRole> getAllUserRole() {
        return this.service.getAllUserRole();
    }

    //get all UserRole by id
    @GetMapping("/{id}")
    public UserRole getUserRoleById(@PathVariable(value = "id") long objId) {
        return this.service.getUserRoleById(objId);
    }

    //create UserRole
    @PostMapping
    public UserRole createUserRole(@RequestBody UserRoleDto userRoleDto) {

        User user = serviceUser.getUserById(userRoleDto.getUserId());
        Role role = serviceRole.getRoleById(userRoleDto.getRoleId());
        userRoleDto.setRole(role);
        userRoleDto.setUser(user);

        return this.service.createUserRole(userRoleDto);
    }

    //update UserRole
    @PutMapping("/{id}")
    public UserRole updateUserRole(@RequestBody UserRoleDto userRoleDto,
                                   @PathVariable(value = "id") long objId) {

        User user = serviceUser.getUserById(userRoleDto.getUserId());
        Role role = serviceRole.getRoleById(userRoleDto.getRoleId());
        userRoleDto.setRole(role);
        userRoleDto.setUser(user);

        return this.service.updateUserRole(userRoleDto, objId);
    }

    //delete UserRole
    @DeleteMapping("/{id}")
    public ResponseEntity<UserRole> deleteUserRole(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserRole(objId);
    }
}
