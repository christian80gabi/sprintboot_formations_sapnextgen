package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserSkillDto;
import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserSkill;
import java.util.List;

public interface UserSkillService  {
    public List<UserSkill> getAllUserSkill();
    public UserSkill getUserSkillById(long objId);
    public List<Skill> getSkillsByUser(long userId);
    public List<User> getUsersBySkill(long skillId);
    public UserSkill createUserSkill(UserSkillDto userSkillDto);
    public UserSkill updateUserSkill(UserSkillDto userSkillDto, long objId);
    public ResponseEntity<UserSkill> deleteUserSkill(long objId);

}