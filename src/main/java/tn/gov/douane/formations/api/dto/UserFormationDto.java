package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Formation;
import tn.gov.douane.formations.api.model.User;
import java.util.List;

public class UserFormationDto {

    private int id;
    private int formationId;
    private int userId;
    private double note;
    private User user;
    private Formation formation;
    private List<User> users;
    private List<Formation> formations;

    public UserFormationDto() {
    }

    public UserFormationDto(int id, int formationId, int userId) {
        this.id = id;
        this.formationId = formationId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFormationId() {
        return this.formationId;
    }

    public void setFormationId(int formationId) {
        this.formationId = formationId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
