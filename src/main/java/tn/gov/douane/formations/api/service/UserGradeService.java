package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserGradeDto;
import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserGrade;

import java.util.List;

public interface UserGradeService {

    public List<UserGrade> getAllUserGrade();
    public UserGrade getUserGradeById(long objId);
    public List<Grade> getGradesByUser(long userId);
    public List<User> getUsersByGrade(long gradeId);
    public UserGrade createUserGrade(UserGradeDto userGradeDto);
    public UserGrade updateUserGrade(UserGradeDto userGradeDto, long objId);
    public ResponseEntity<UserGrade> deleteUserGrade(long objId);
}
