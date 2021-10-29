package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserFormationDto;
import tn.gov.douane.formations.api.model.Formation;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserFormation;
import java.util.List;

public interface UserFormationService {
    public List<UserFormation> getAllUserFormation();
    public UserFormation getUserFormationById(long objId);
    public List<Formation> getFormationsByUser(long userId);
    public List<User> getUsersByFormation(long formationId);
    public UserFormation createUserFormation(UserFormationDto userFormationDto);
    public UserFormation updateUserFormation(UserFormationDto userFormationDto, long objId);
    public ResponseEntity<UserFormation> deleteUserFormation(long objId);
}