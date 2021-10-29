package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserSkillDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserSkill;
import tn.gov.douane.formations.api.repository.UserSkillRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserSkillServiceImpl implements UserSkillService{

    @Autowired
    private UserSkillRepository repo;

    public UserSkillServiceImpl() {
        super();
    }

    public UserSkillServiceImpl(UserSkillRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserSkill> getAllUserSkill() {
        return this.repo.findAll();
    }

    @Override
    public UserSkill getUserSkillById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User skill not found with id :"+objId)
                );
    }


    @Override
    public UserSkill createUserSkill(UserSkillDto userSkillDto) {

        Timestamp time = GDate.precisionDateTime;
        UserSkill userSkill = new UserSkill();

        userSkill.setSkillId(userSkillDto.getSkill());
        userSkill.setUserId(userSkillDto.getUser());
        userSkill.setUserSkillCreateAt(time);
        userSkill.setUserSkillUpdateAt(time);
        userSkill.setUserSkillDeleteAt(time);
        userSkill.setStatut(GStatutObj.ADD);

        return this.repo.save(userSkill);
    }

    @Override
    public UserSkill updateUserSkill(UserSkillDto userSkillDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserSkill existingUserSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User skill not found with id :"+objId));

        existingUserSkill.setSkillId(userSkillDto.getSkill());
        existingUserSkill.setUserId(userSkillDto.getUser());
        existingUserSkill.setUserSkillUpdateAt(time);
        existingUserSkill.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserSkill);
    }

    @Override
    public ResponseEntity<UserSkill> deleteUserSkill(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserSkill existingUserSkill = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User skill not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserSkill);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Skill> getSkillsByUser(long userId) {

        List<UserSkill> userSkills = repo.findAll();
        List<Skill> resultat = new ArrayList<Skill>();

        for (UserSkill obj : userSkills) {

            if (userId == obj.getUserId().getId()){
                resultat.add(obj.getSkillId());
            }
        }

        return resultat;
    }

    @Override
    public List<User> getUsersBySkill(long skillId) {

        List<UserSkill> userSkills = repo.findAll();
        List<User> resultat = new ArrayList<User>();

        for (UserSkill obj : userSkills) {

            if (skillId == obj.getSkillId().getId()){
                resultat.add(obj.getUserId());
            }
        }

        return resultat;
    }
}
