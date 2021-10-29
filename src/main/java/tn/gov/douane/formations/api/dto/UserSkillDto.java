package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.Skill;
import tn.gov.douane.formations.api.model.User;

import java.util.List;

public class UserSkillDto {

    private int id;
    private int skillId;
    private int userId;
    private User user;
    private Skill skill;
    private List<User> users;
    private List<Skill> skills;

    public UserSkillDto() {
    }

    public UserSkillDto(int id, int skillId, int userId) {
        this.id = id;
        this.skillId = skillId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkillId() {
        return this.skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
