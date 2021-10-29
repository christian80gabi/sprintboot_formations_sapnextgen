package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserFormationDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.*;
import tn.gov.douane.formations.api.repository.UserFormationRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserFormationServiceImpl implements UserFormationService{

    @Autowired
    private UserFormationRepository repo;

    public UserFormationServiceImpl() {
        super();
    }

    public UserFormationServiceImpl(UserFormationRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserFormation> getAllUserFormation() {
        return this.repo.findAll();
    }

    @Override
    public UserFormation getUserFormationById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User formation not found with id :"+objId)
                );
    }

    @Override
    public UserFormation createUserFormation(UserFormationDto userFormationDto) {

        Timestamp time = GDate.precisionDateTime;
        UserFormation userFormation = new UserFormation();

        userFormation.setFormationId(userFormationDto.getFormation());
        userFormation.setUserId(userFormationDto.getUser());
        userFormation.setNote(userFormationDto.getNote());
        userFormation.setUserFormationCreateAt(time);
        userFormation.setUserFormationUpdateAt(time);
        userFormation.setUserFormationDeleteAt(time);
        userFormation.setStatut(GStatutObj.ADD);

        return this.repo.save(userFormation);
    }

    @Override
    public UserFormation updateUserFormation(UserFormationDto userFormationDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserFormation existingUserFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User formation not found with id :"+objId));

        existingUserFormation.setFormationId(userFormationDto.getFormation());
        existingUserFormation.setUserId(userFormationDto.getUser());
        existingUserFormation.setNote(userFormationDto.getNote());
        existingUserFormation.setUserFormationUpdateAt(time);
        existingUserFormation.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserFormation);
    }

    @Override
    public ResponseEntity<UserFormation> deleteUserFormation(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserFormation existingUserFormation = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User formation not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserFormation);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Formation> getFormationsByUser(long userId) {

        List<UserFormation> userFormations = repo.findAll();
        List<Formation> resultat = new ArrayList<Formation>();

        for (UserFormation obj : userFormations) {

            if (userId == obj.getUserId().getId()){
                resultat.add(obj.getFormationId());
            }
        }

        return resultat;
    }

    @Override
    public List<User> getUsersByFormation(long formationId) {

        List<UserFormation> userFormations = repo.findAll();
        List<User> resultat = new ArrayList<User>();

        for (UserFormation obj : userFormations) {

            if (formationId == obj.getFormationId().getId()){
                resultat.add(obj.getUserId());
            }
        }

        return resultat;
    }
}
