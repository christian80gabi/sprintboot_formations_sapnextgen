package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserSkillDto;
import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserSkill;
import tn.gov.douane.formations.api.service.SkillServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;
import tn.gov.douane.formations.api.service.UserSkillServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/userskill")
public class UserSkillControllerImpl implements UserSkillController {

    @Autowired
    private UserSkillServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    @Autowired
    private SkillServiceImpl serviceSkill;

    public UserSkillControllerImpl(){ super();}

    public UserSkillControllerImpl(UserSkillServiceImpl service){
        super();
        this.service = service;
    }
    //get all UserSkill
    @GetMapping
    public List<UserSkill> getAllUserSkill() {
        return this.service.getAllUserSkill();
    }

    //get all UserSkill by id
    @GetMapping("/{id}")
    public UserSkill getUserSkillById(@PathVariable(value = "id") long objId) {
        return this.service.getUserSkillById(objId);
    }

    //create UserSkill
    @PostMapping
    public UserSkill createUserSkill(@RequestBody UserSkillDto userSkillDto) {

        Skill skill = serviceSkill.getSkillById(userSkillDto.getSkillId());
        User user = serviceUser.getUserById(userSkillDto.getUserId());
        userSkillDto.setSkill(skill);
        userSkillDto.setUser(user);

        return this.service.createUserSkill(userSkillDto);
    }

    //update UserSkill
    @PutMapping("/{id}")
    public UserSkill updateUserSkill(@RequestBody UserSkillDto userSkillDto,
                                     @PathVariable(value = "id") long objId) {

        Skill skill = serviceSkill.getSkillById(userSkillDto.getSkillId());
        User user = serviceUser.getUserById(userSkillDto.getUserId());
        userSkillDto.setSkill(skill);
        userSkillDto.setUser(user);

        return this.service.updateUserSkill(userSkillDto, objId);
    }

    //delete UserSkill
    @DeleteMapping("/{id}")
    public ResponseEntity<UserSkill> deleteUserSkill(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserSkill(objId);
    }

    @GetMapping("user_skill_user/{userSkillUserId}")
    public List<Skill> getSkillsByUser(@PathVariable(value = "userSkillUserId") long userId) {
        return this.service.getSkillsByUser(userId);
    }

    @GetMapping("user_skill_skill/{userSkillSkillId}")
    public List<User> getUsersBySkill(@PathVariable(value = "userSkillSkillId") long skillId) {
        return this.service.getUsersBySkill(skillId);
    }
}
