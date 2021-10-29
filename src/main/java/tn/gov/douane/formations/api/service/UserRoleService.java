package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserRoleDto;
import tn.gov.douane.formations.api.model.UserRole;
import java.util.List;

public interface UserRoleService {
    public List<UserRole> getAllUserRole();
    public UserRole getUserRoleById(long objId);
    public UserRole createUserRole(UserRoleDto userRoleDto);
    public UserRole updateUserRole(UserRoleDto userRoleDto, long objId);
    public ResponseEntity<UserRole> deleteUserRole(long objId);

}
