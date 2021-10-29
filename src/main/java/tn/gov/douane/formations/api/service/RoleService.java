package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.RoleDto;
import tn.gov.douane.formations.api.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRole();
    public Role getRoleById(long objId);
    public Role getRoleByLabel(String label);
    public Role createRole(RoleDto roleDto);
    public Role updateRole(RoleDto roleDto, long objId);
    public ResponseEntity<Role> deleteRole(long objId);
}