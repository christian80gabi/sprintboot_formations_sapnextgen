package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_skill")
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_skill_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skillId;

    @Column(name = "user_skill_create_at")
    private Timestamp userSkillCreateAt;

    @Column(name = "user_skill_update_at")
    private Timestamp userSkillUpdateAt;

    @Column(name = "user_skill_delete_at")
    private Timestamp userSkillDeleteAt;

    @Column(name = "user_skill_statut")
    private int statut;

    public UserSkill() {
    }

    public UserSkill(User userId, Skill skillId, Timestamp userSkillCreateAt, Timestamp userSkillUpdateAt, Timestamp userSkillDeleteAt, int statut) {
        this.userId = userId;
        this.skillId = skillId;
        this.userSkillCreateAt = userSkillCreateAt;
        this.userSkillUpdateAt = userSkillUpdateAt;
        this.userSkillDeleteAt = userSkillDeleteAt;
        this.statut = statut;
    }

    public UserSkill(UserSkill userSkill) {
        this.id = userSkill.id;
        this.userId = userSkill.userId;
        this.skillId = userSkill.skillId;
        this.userSkillCreateAt = userSkill.userSkillCreateAt;
        this.userSkillUpdateAt = userSkill.userSkillUpdateAt;
        this.userSkillDeleteAt = userSkill.userSkillDeleteAt;
        this.statut = userSkill.statut;
    }

    public long getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    public Timestamp getUserSkillCreateAt() {
        return userSkillCreateAt;
    }

    public void setUserSkillCreateAt(Timestamp userSkillCreateAt) {
        this.userSkillCreateAt = userSkillCreateAt;
    }

    public Timestamp getUserSkillUpdateAt() {
        return userSkillUpdateAt;
    }

    public void setUserSkillUpdateAt(Timestamp userSkillUpdateAt) {
        this.userSkillUpdateAt = userSkillUpdateAt;
    }

    public Timestamp getUserSkillDeleteAt() {
        return userSkillDeleteAt;
    }

    public void setUserSkillDeleteAt(Timestamp userSkillDeleteAt) {
        this.userSkillDeleteAt = userSkillDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", userId=" + userId +
                ", skillId=" + skillId +
                ", userSkillCreateAt=" + userSkillCreateAt +
                ", userSkillUpdateAt=" + userSkillUpdateAt +
                ", userSkillDeleteAt=" + userSkillDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserSkill)) return false;
        UserSkill userSkill = (UserSkill) o;
        return getId() == userSkill.getId() &&
                getStatut() == userSkill.getStatut() &&
                getUserId().equals(userSkill.getUserId()) &&
                getSkillId().equals(userSkill.getSkillId()) &&
                getUserSkillCreateAt().equals(userSkill.getUserSkillCreateAt()) &&
                getUserSkillUpdateAt().equals(userSkill.getUserSkillUpdateAt()) &&
                getUserSkillDeleteAt().equals(userSkill.getUserSkillDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getSkillId(), getUserSkillCreateAt(), getUserSkillUpdateAt(), getUserSkillDeleteAt(), getStatut());
    }
}
