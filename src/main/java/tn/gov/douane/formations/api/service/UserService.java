package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.model.User;
import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public User getUserById(long objId);
    public User getUserByMatricule(String matricule);
    public User getUserByEmail(String email);
    public User getUserByUsernamePassword(String username, String password);
    public User createUser(UserDto userDto);
    public User updateUser(UserDto userDto, long objId);
    public ResponseEntity<User> deleteUser(long objId);
}