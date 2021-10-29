package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserRoleDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.UserRole;
import tn.gov.douane.formations.api.repository.UserRoleRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository repo;

    public UserRoleServiceImpl() {
        super();
    }

    public UserRoleServiceImpl(UserRoleRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return this.repo.findAll();
    }

    @Override
    public UserRole getUserRoleById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User role not found with id :"+objId)
                );
    }

    @Override
    public UserRole createUserRole(UserRoleDto userRoleDto) {

        Timestamp time = GDate.precisionDateTime;
        UserRole userRole = new UserRole();

        userRole.setRoleId(userRoleDto.getRole());
        userRole.setUserId(userRoleDto.getUser());
        userRole.setUserRoleCreateAt(time);
        userRole.setUserRoleUpdateAt(time);
        userRole.setUserRoleDeleteAt(time);
        userRole.setStatut(GStatutObj.ADD);

        return this.repo.save(userRole);
    }

    @Override
    public UserRole updateUserRole(UserRoleDto userRoleDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserRole existingUserRole = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User role not found with id :"+objId));

        existingUserRole.setRoleId(userRoleDto.getRole());
        existingUserRole.setUserId(userRoleDto.getUser());
        existingUserRole.setUserRoleUpdateAt(time);
        existingUserRole.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserRole);
    }

    @Override
    public ResponseEntity<UserRole> deleteUserRole(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserRole existingUserRole = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User role not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserRole);
        return ResponseEntity.ok().build();
    }
}
