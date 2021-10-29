package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Grade;
import tn.gov.douane.formations.api.model.User;
import java.util.List;

public class UserGradeDto {

    private int id;
    private int userId;
    private int gradeId;
    private User user;
    private Grade grade;
    private List<User> users;
    private List<Grade> grades;

    public UserGradeDto() {
    }

    public UserGradeDto(int id, int userId, int gradeId) {
        this.id = id;
        this.userId = userId;
        this.gradeId = gradeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
