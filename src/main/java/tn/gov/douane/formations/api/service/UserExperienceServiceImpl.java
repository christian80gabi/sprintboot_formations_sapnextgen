package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserExperienceDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.*;
import tn.gov.douane.formations.api.repository.UserExperienceRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserExperienceServiceImpl implements UserExperienceService {

    @Autowired
    private UserExperienceRepository repo;

    public UserExperienceServiceImpl() {
        super();
    }

    public UserExperienceServiceImpl(UserExperienceRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserExperience> getAllUserExperience() {
        return this.repo.findAll();
    }

    @Override
    public UserExperience getUserExperienceById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User experience not found with id :"+objId)
                );
    }

    public UserExperience createUserExperience(UserExperienceDto userExperienceDto) {

        Timestamp time = GDate.precisionDateTime;
        UserExperience userExperience = new UserExperience();

        userExperience.setExperienceId(userExperienceDto.getExperience());
        userExperience.setUserId(userExperienceDto.getUser());
        userExperience.setUserExperienceCreateAt(time);
        userExperience.setUserExperienceUpdateAt(time);
        userExperience.setUserExperienceDeleteAt(time);
        userExperience.setStatut(GStatutObj.ADD);

        return this.repo.save(userExperience);
    }

    @Override
    public UserExperience updateUserExperience(UserExperienceDto userExperienceDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserExperience existingUserExperience = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User experience not found with id :"+objId));

        existingUserExperience.setExperienceId(userExperienceDto.getExperience());
        existingUserExperience.setUserId(userExperienceDto.getUser());
        existingUserExperience.setUserExperienceUpdateAt(time);
        existingUserExperience.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserExperience);
    }

    @Override
    public ResponseEntity<UserExperience> deleteUserExperience(long objId) {
        //Timestamp time = GDate.precisionDateTime;
        UserExperience existingUserExperience = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User experience not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserExperience);
        return ResponseEntity.ok().build();
    }

    public List<Experience> getExperiencesByUser(long userId) {

        List<UserExperience> userExperiences = repo.findAll();
        List<Experience> resultat = new ArrayList<Experience>();

        for (UserExperience obj : userExperiences) {

            if (userId == obj.getUserId().getId()){
                resultat.add(obj.getExperienceId());
            }
        }

        return resultat;
    }

    public List<User> getUsersByExperience(long expId) {

        List<UserExperience> userExperiences = repo.findAll();
        List<User> resultat = new ArrayList<User>();

        for (UserExperience obj : userExperiences) {

            if (expId == obj.getExperienceId().getId()){
                resultat.add(obj.getUserId());
            }
        }

        return resultat;
    }
}
