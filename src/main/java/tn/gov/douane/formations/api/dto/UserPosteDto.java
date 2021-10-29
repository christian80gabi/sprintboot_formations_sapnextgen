package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Poste;
import tn.gov.douane.formations.api.model.User;
import java.util.List;

public class UserPosteDto {

    private int id;
    private int userId;
    private int posteId;
    private User user;
    private Poste poste;
    private List<User> users;
    private List<Poste> postes;

    public UserPosteDto() {
    }

    public UserPosteDto(int id, int userId, int posteId) {
        this.id = id;
        this.userId = userId;
        this.posteId = posteId;
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

    public int getPosteId() {
        return posteId;
    }

    public void setPosteId(int posteId) {
        this.posteId = posteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }
}
