package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.RoleDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Role;
import tn.gov.douane.formations.api.repository.RoleRepository;

import java.sql.Timestamp;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository repo;

    public RoleServiceImpl() {
        super();
    }

    public RoleServiceImpl(RoleRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<Role> getAllRole() {
        return this.repo.findAll();
    }

    @Override
    public Role getRoleById(long objId) {
        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("Role not found with id :"+objId)
                );
    }

    @Override
    public Role getRoleByLabel(String label) {

        List<Role> roles = repo.findAll();
        Role resultat = null;

        for (Role obj : roles) {
            if (label.equalsIgnoreCase(obj.getRoleLabel())){
                resultat = new Role(obj);
                break;
            }
        }

        return resultat;
    }

    @Override
    public Role createRole(RoleDto roleDto) {

        Timestamp time = GDate.precisionDateTime;
        Role role = new Role();

        role.setRoleLabel(roleDto.getRoleLabel());
        role.setRoleDescription(roleDto.getRoleDescription());
        role.setRoleCreateAt(time);
        role.setRoleUpdateAt(time);
        role.setRoleDeleteAt(time);
        role.setStatut(GStatutObj.ADD);

        return this.repo.save(role);
    }

    @Override
    public Role updateRole(RoleDto roleDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        Role existingRole = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Role not found with id :"+objId));

        existingRole.setRoleLabel(roleDto.getRoleLabel());
        existingRole.setRoleDescription(roleDto.getRoleDescription());
        existingRole.setRoleUpdateAt(time);
        existingRole.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingRole);
    }

    @Override
    public ResponseEntity<Role> deleteRole(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        Role existingRole = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("Role not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingRole);
        return ResponseEntity.ok().build();
    }
}
