package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Experience;
import tn.gov.douane.formations.api.model.User;

import java.util.List;

public class UserExperienceDto {

    private int id;
    private int expId;
    private int userId;
    private User user;
    private Experience experience;
    private List<User> users;
    private List<Experience> experiences;

    public UserExperienceDto() {
    }

    public UserExperienceDto(int id, int expId, int userId) {
        this.id = id;
        this.expId = expId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpId() {
        return this.expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
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

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
