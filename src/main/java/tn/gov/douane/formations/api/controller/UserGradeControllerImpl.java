package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserGradeDto;
import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserGrade;
import tn.gov.douane.formations.api.service.GradeServiceImpl;
import tn.gov.douane.formations.api.service.UserGradeServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/usergrade")
public class UserGradeControllerImpl implements UserGradeController{

    @Autowired
    private UserGradeServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    @Autowired
    private GradeServiceImpl serviceGrade;

    public UserGradeControllerImpl() {
        super();
    }

    public UserGradeControllerImpl(UserGradeServiceImpl service) {
        super();
        this.service = service;
    }

    @GetMapping
    @Override
    public List<UserGrade> getAllUserGrade() {
        return this.service.getAllUserGrade();
    }

    @GetMapping("/{id}")
    @Override
    public UserGrade getUserGradeById(@PathVariable(value = "id") long objId) {
        return this.service.getUserGradeById(objId);
    }

    @PostMapping
    @Override
    public UserGrade createUserGrade(@RequestBody UserGradeDto userGradeDto) {

        Grade grade = serviceGrade.getGradeById(userGradeDto.getGradeId());
        User user = serviceUser.getUserById(userGradeDto.getUserId());
        userGradeDto.setGrade(grade);
        userGradeDto.setUser(user);

        return this.service.createUserGrade(userGradeDto);
    }

    @PutMapping("/{id}")
    @Override
    public UserGrade updateUserGrade(@RequestBody UserGradeDto userGradeDto, @PathVariable(value = "id") long objId) {

        Grade grade = serviceGrade.getGradeById(userGradeDto.getGradeId());
        User user = serviceUser.getUserById(userGradeDto.getUserId());
        userGradeDto.setGrade(grade);
        userGradeDto.setUser(user);

        return this.service.updateUserGrade(userGradeDto, objId);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<UserGrade> deleteUserGrade(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserGrade(objId);
    }

    @GetMapping("user_grade_user/{userGradeUserId}")
    @Override
    public List<Grade> getGradesByUser(@PathVariable(value = "userGradeUserId") long userId) {
        return this.service.getGradesByUser(userId);
    }

    @GetMapping("user_grade_grade/{userGradeGradeId}")
    @Override
    public List<User> getUsersByGrade(@PathVariable(value = "userGradeGradeId") long gradeId) {
        return this.service.getUsersByGrade(gradeId);
    }
}
