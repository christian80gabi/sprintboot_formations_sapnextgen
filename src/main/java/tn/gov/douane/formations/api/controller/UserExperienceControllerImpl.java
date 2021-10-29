package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserExperienceDto;
import tn.gov.douane.formations.api.model.Experience;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserExperience;
import tn.gov.douane.formations.api.service.ExperienceServiceImpl;
import tn.gov.douane.formations.api.service.UserExperienceServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/userexperience")
public class UserExperienceControllerImpl implements UserExperienceController {

    @Autowired
    private UserExperienceServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    @Autowired
    private ExperienceServiceImpl serviceExperience;

    public UserExperienceControllerImpl (){ super();}

    public UserExperienceControllerImpl(UserExperienceServiceImpl service){
        super();
        this.service = service;
    }

    //get all UserExperience
    @GetMapping
    public List<UserExperience> getAllUserExperience() {
        return this.service.getAllUserExperience();
    }

    //get all UserExperience by id
    @GetMapping("/{id}")
    public UserExperience getUserExperienceById(@PathVariable(value = "id") long objId) {
        return this.service.getUserExperienceById(objId);
    }

    //create UserExperience
    @PostMapping
    public UserExperience createUserExperience(@RequestBody UserExperienceDto userExperienceDto) {

        User user = serviceUser.getUserById(userExperienceDto.getUserId());
        Experience exp = serviceExperience.getExperienceById(userExperienceDto.getExpId());
        userExperienceDto.setUser(user);
        userExperienceDto.setExperience(exp);

        return this.service.createUserExperience(userExperienceDto);
    }

    //update UserExperience
    @PutMapping("/{id}")
    public UserExperience updateUserExperience(@RequestBody UserExperienceDto userExperienceDto,
                                               @PathVariable(value = "id") long objId) {

        User user = serviceUser.getUserById(userExperienceDto.getUserId());
        Experience exp = serviceExperience.getExperienceById(userExperienceDto.getExpId());
        userExperienceDto.setUser(user);
        userExperienceDto.setExperience(exp);

        return this.service.updateUserExperience(userExperienceDto, objId);
    }

    //delete UserExperience
    @DeleteMapping("/{id}")
    public ResponseEntity<UserExperience> deleteUserExperience(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserExperience(objId);
    }

    @GetMapping("user_exp_user/{userExperienceUserId}")
    public List<Experience> getExperiencesByUser(@PathVariable(value = "userExperienceUserId") long userId) {
        return this.service.getExperiencesByUser(userId);
    }

    @GetMapping("user_exp_user/{userExperienceExpId}")
    public List<User> getUsersByExperience(@PathVariable(value = "userExperienceExpId") long expId) {
        return this.service.getUsersByExperience(expId);
    }
}
