package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.repository.UserRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public UserServiceImpl() {
        super();
    }

    public UserServiceImpl(UserRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<User> getAllUser() {
        return this.repo.findAll();
    }

    @Override
    public User getUserById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User not found with id :"+objId)
                );
    }

    @Override
    public User createUser(UserDto userDto) {

        Timestamp time = GDate.precisionDateTime;
        User user = new User();

        user.setUserMatricule(userDto.getUserMatricule());
        user.setUserFirstName(userDto.getUserFirstName());
        user.setUserLastName(userDto.getUserLastName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPhone(userDto.getUserPhone());
        user.setUserPhoto(userDto.getUserPhoto());
        user.setUserName(userDto.getUserName());
        user.setUserPassword(userDto.getUserPassword());
        user.setTypeUserId(userDto.getTypeUser());
        user.setUserCreateAt(time);
        user.setUserUpdateAt(time);
        user.setUserDeleteAt(time);
        user.setUserStatut(GStatutObj.ADD);

        return this.repo.save(user);
    }

    @Override
    public User updateUser(UserDto userDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        User existingUser = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User not found with id :"+objId));

        existingUser.setUserMatricule(userDto.getUserMatricule());
        existingUser.setUserFirstName(userDto.getUserFirstName());
        existingUser.setUserLastName(userDto.getUserLastName());
        existingUser.setUserEmail(userDto.getUserEmail());
        existingUser.setUserPhone(userDto.getUserPhone());
        existingUser.setUserPhoto(userDto.getUserPhoto());
        existingUser.setUserName(userDto.getUserName());
        existingUser.setUserPassword(userDto.getUserPassword());
        existingUser.setTypeUserId(userDto.getTypeUser());
        existingUser.setUserUpdateAt(time);
        existingUser.setUserStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUser);
    }

    @Override
    public ResponseEntity<User> deleteUser(long objId) {
        //Timestamp time = GDate.precisionDateTime;
        User existingUser = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUser);
        return ResponseEntity.ok().build();
    }

    @Override
    public User getUserByMatricule(String matricule) {

        List<User> users = repo.findAll();
        User user = null;

        for (User obj : users) {

            if (matricule.equalsIgnoreCase(obj.getUserMatricule())){
                user = new User(obj);
                break;
            }
        }

        return user;
    }

    @Override
    public User getUserByEmail(String email) {

        List<User> users = repo.findAll();
        User user = null;

        for (User obj : users) {

            if (email.equalsIgnoreCase(obj.getUserEmail())){
                user = new User(obj);
                break;
            }
        }

        return user;
    }

    @Override
    public User getUserByUsernamePassword(String username, String password) {

        List<User> users = repo.findAll();
        User user = null;

        for (User obj : users) {

            if (username.equalsIgnoreCase(obj.getUserName())){

                if (password.equalsIgnoreCase(obj.getUserPassword())){
                    user = new User(obj);
                    break;
                }
            }
        }

        return user;
    }
}
