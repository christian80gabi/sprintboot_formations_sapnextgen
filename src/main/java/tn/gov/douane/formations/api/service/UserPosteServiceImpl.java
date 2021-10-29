package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserPosteDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.*;
import tn.gov.douane.formations.api.repository.UserPosteRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPosteServiceImpl implements UserPosteService{

    @Autowired
    private UserPosteRepository repo;

    public UserPosteServiceImpl() {
        super();
    }

    public UserPosteServiceImpl(UserPosteRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserPoste> getAllUserPoste() {
        return this.repo.findAll();
    }

    @Override
    public UserPoste getUserPosteById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User poste not found with id :"+objId)
                );
    }

    @Override
    public UserPoste createUserPoste(UserPosteDto userPosteDto) {

        Timestamp time = GDate.precisionDateTime;
        UserPoste userPoste = new UserPoste();

        userPoste.setPosteId(userPosteDto.getPoste());
        userPoste.setUserId(userPosteDto.getUser());
        userPoste.setUserPosteCreateAt(time);
        userPoste.setUserPosteUpdateAt(time);
        userPoste.setUserPosteDeleteAt(time);
        userPoste.setStatut(GStatutObj.ADD);

        return this.repo.save(userPoste);
    }

    @Override
    public UserPoste updateUserPoste(UserPosteDto userPosteDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserPoste existingUserPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User poste not found with id :"+objId));

        existingUserPoste.setPosteId(userPosteDto.getPoste());
        existingUserPoste.setUserId(userPosteDto.getUser());
        existingUserPoste.setUserPosteUpdateAt(time);
        existingUserPoste.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserPoste);
    }

    @Override
    public ResponseEntity<UserPoste> deleteUserPoste(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserPoste existingUserPoste = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User poste not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserPoste);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Poste> getPostesByUser(long userId) {

        List<UserPoste> userPostes = repo.findAll();
        List<Poste> resultat = new ArrayList<Poste>();

        for (UserPoste obj : userPostes) {

            if (userId == obj.getUserId().getId()){
                resultat.add(obj.getPosteId());
            }
        }

        return resultat;
    }

    @Override
    public List<User> getUsersByPoste(long posteId) {

        List<UserPoste> userPostes = repo.findAll();
        List<User> resultat = new ArrayList<User>();

        for (UserPoste obj : userPostes) {

            if (posteId == obj.getPosteId().getId()){
                resultat.add(obj.getUserId());
            }
        }

        return resultat;
    }
}
