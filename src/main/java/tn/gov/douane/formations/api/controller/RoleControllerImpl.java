package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.RoleDto;
import tn.gov.douane.formations.api.model.Role;
import tn.gov.douane.formations.api.service.RoleServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/role")
public class RoleControllerImpl implements RoleController {

    @Autowired
    private RoleServiceImpl service;

    public RoleControllerImpl(){ super();}

    public RoleControllerImpl(RoleServiceImpl service){
        super();
        this.service = service;
    }

    //get all role
    @GetMapping
    public List<Role> getAllRole() {
        return this.service.getAllRole();
    }

    //get all role  by id
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(value = "id") long objId) {
        return this.service.getRoleById(objId);
    }

    //get all role by label
    @GetMapping("/")
    @ResponseBody
    public Role getRoleByLabel(@RequestParam String label) {
        return this.service.getRoleByLabel(label);
    }

    // create role
    @PostMapping
    public Role createRole(@RequestBody RoleDto roleDto) {
        return this.service.createRole(roleDto);
    }

    // update role
    @PutMapping("/{id}")
    public Role updateRole(@RequestBody RoleDto roleDto, @PathVariable(value = "id") long objId) {
        return this.service.updateRole(roleDto, objId);
    }

    //delete role
    @DeleteMapping("/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable (value = "id") long objId) {
        return null;
    }
}
