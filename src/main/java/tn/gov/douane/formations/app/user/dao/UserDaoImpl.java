package tn.gov.douane.formations.app.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import tn.gov.douane.formations.api.dto.AgentDto;
import tn.gov.douane.formations.api.dto.UserDto;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.app.URL_INFO;
import tn.gov.douane.formations.app.user.dao.interfaces.IUserDao;

import java.util.Arrays;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private static final String ALL_USERS_API = URL_INFO.url+"user";
    private static final String USER_BY_ID_API = URL_INFO.url+"user"+"/"+"{id}";
    private static final String USER_BY_MATRICULE_API = URL_INFO.url+"user"+"/"+"matricule"+"/"+"{matricule}";
    private static final String USER_BY_EMAIL_API = URL_INFO.url+"user"+"/"+"email"+"/"+"{email}";
    private static final String USER_BY_USERNAME_PASSWORD_API = URL_INFO.url+"user"+"/"+"username_password"+"/"+"{username}"+"/"+"{password}";
    private static final String CREATE_USER_API = URL_INFO.url+"user";
    private static final String UPDATE_USER_API =  URL_INFO.url+"user"+"/"+"{id}";

    public UserDaoImpl() {
    }

    @Override
    public User createUser(UserDto dto) {
        User user = restTemplate.postForObject(CREATE_USER_API, dto, User.class);

        return user;
    }

    @Override
    public User updateUser(UserDto dto) {
        restTemplate.put(UPDATE_USER_API, dto, dto.getId());
        User user = getUserById(dto.getId());

        return user;
    }

    @Override
    public User getUserById(long id) {
        User user = restTemplate.getForObject(USER_BY_ID_API, User.class, id);

        return user;
    }

    @Override
    public User getUserByMatricule(String matricule) {
        User user = restTemplate.getForObject(USER_BY_MATRICULE_API, User.class, matricule);

        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = restTemplate.getForObject(USER_BY_EMAIL_API, User.class, email);

        return user;
    }

    @Override
    public User getUserByUsernamePassword(String username, String password) {
        User user = restTemplate.getForObject(USER_BY_USERNAME_PASSWORD_API, User.class, username, password);

        return user;
    }

    @Override
    public List<User> getAllUser() {
        User[] list = restTemplate.getForObject(ALL_USERS_API, User[].class);
        List<User> users = Arrays.asList(list);

        return users;
    }

    @Override
    public boolean existsUser(AgentDto dto) {

        boolean reponse = false;
        List<User> liste = this.getAllUser();
        String matricule = dto.getMatricule();

        for (User user : liste) {
            if (matricule.equalsIgnoreCase(user.getUserMatricule())){
                reponse = true;
                break;
            }
        }

        return reponse;
    }
}
