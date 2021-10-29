package tn.gov.douane.formations.app.user.dao.interfaces;

import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.model.User;
import java.util.List;

public interface IUserDao {

    public User createUser(UserDto dto);
    public User updateUser(UserDto dto);
    public User getUserById(long id);
    public User getUserByMatricule(String matricule);
    public User getUserByEmail(String email);
    public User getUserByUsernamePassword(String username, String password);
    public List<User> getAllUser();
    public boolean existsUser(AgentDto dto);
}
