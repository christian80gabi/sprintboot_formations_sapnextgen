package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserGradeDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.*;
import tn.gov.douane.formations.api.repository.UserGradeRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserGradeServiceImpl implements UserGradeService{

    @Autowired
    private UserGradeRepository repo;

    public UserGradeServiceImpl() {
        super();
    }

    public UserGradeServiceImpl(UserGradeRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserGrade> getAllUserGrade() {
        return this.repo.findAll();
    }

    @Override
    public UserGrade getUserGradeById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User grade not found with id :"+objId)
                );
    }

    @Override
    public UserGrade createUserGrade(UserGradeDto userGradeDto) {

        Timestamp time = GDate.precisionDateTime;
        UserGrade userGrade = new UserGrade();

        userGrade.setGradeId(userGradeDto.getGrade());
        userGrade.setUserId(userGradeDto.getUser());
        userGrade.setUserGradeCreateAt(time);
        userGrade.setUserGradeUpdateAt(time);
        userGrade.setUserGradeDeleteAt(time);
        userGrade.setStatut(GStatutObj.ADD);

        return this.repo.save(userGrade);
    }

    @Override
    public UserGrade updateUserGrade(UserGradeDto userGradeDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserGrade existingUserGrade = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User grade not found with id :"+objId));

        existingUserGrade.setGradeId(userGradeDto.getGrade());
        existingUserGrade.setUserId(userGradeDto.getUser());
        existingUserGrade.setUserGradeUpdateAt(time);
        existingUserGrade.setStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserGrade);
    }

    @Override
    public ResponseEntity<UserGrade> deleteUserGrade(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserGrade existingUserGrade = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User grade not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserGrade);
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Grade> getGradesByUser(long userId) {

        List<UserGrade> userGrades = repo.findAll();
        List<Grade> resultat = new ArrayList<Grade>();

        for (UserGrade obj : userGrades) {

            if (userId == obj.getUserId().getId()){
                resultat.add(obj.getGradeId());
            }
        }

        return resultat;
    }

    @Override
    public List<User> getUsersByGrade(long gradeId) {

        List<UserGrade> userGrades = repo.findAll();
        List<User> resultat = new ArrayList<User>();

        for (UserGrade obj : userGrades) {

            if (gradeId == obj.getGradeId().getId()){
                resultat.add(obj.getUserId());
            }
        }

        return resultat;
    }
}
