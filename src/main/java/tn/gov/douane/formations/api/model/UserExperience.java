package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_experience")
public class UserExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_experience_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "exp_id")
    private Experience experienceId;

    @Column(name = "user_exp_create_at")
    private Timestamp userExperienceCreateAt;

    @Column(name = "user_exp_update_at")
    private Timestamp userExperienceUpdateAt;

    @Column(name = "user_exp_delete_at")
    private Timestamp userExperienceDeleteAt;

    @Column(name = "user_exp_statut")
    private int statut;

    public UserExperience() {
    }

    public UserExperience(User userId, Experience experienceId,
                          Timestamp userExperienceCreateAt, Timestamp userExperienceUpdateAt,
                          Timestamp userExperienceDeleteAt, int statut) {
        this.userId = userId;
        this.experienceId = experienceId;
        this.userExperienceCreateAt = userExperienceCreateAt;
        this.userExperienceUpdateAt = userExperienceUpdateAt;
        this.userExperienceDeleteAt = userExperienceDeleteAt;
        this.statut = statut;
    }

    public UserExperience(UserExperience userExperience) {
        this.id = userExperience.id;
        this.userId = userExperience.userId;
        this.experienceId = userExperience.experienceId;
        this.userExperienceCreateAt = userExperience.userExperienceCreateAt;
        this.userExperienceUpdateAt = userExperience.userExperienceUpdateAt;
        this.userExperienceDeleteAt = userExperience.userExperienceDeleteAt;
        this.statut = userExperience.statut;
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

    public Experience getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Experience experienceId) {
        this.experienceId = experienceId;
    }

    public Timestamp getUserExperienceCreateAt() {
        return userExperienceCreateAt;
    }

    public void setUserExperienceCreateAt(Timestamp userExperienceCreateAt) {
        this.userExperienceCreateAt = userExperienceCreateAt;
    }

    public Timestamp getUserExperienceUpdateAt() {
        return userExperienceUpdateAt;
    }

    public void setUserExperienceUpdateAt(Timestamp userExperienceUpdateAt) {
        this.userExperienceUpdateAt = userExperienceUpdateAt;
    }

    public Timestamp getUserExperienceDeleteAt() {
        return userExperienceDeleteAt;
    }

    public void setUserExperienceDeleteAt(Timestamp userExperienceDeleteAt) {
        this.userExperienceDeleteAt = userExperienceDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "UserExperience{" +
                "id=" + id +
                ", userId=" + userId +
                ", experienceId=" + experienceId +
                ", userExperienceCreateAt=" + userExperienceCreateAt +
                ", userExperienceUpdateAt=" + userExperienceUpdateAt +
                ", userExperienceDeleteAt=" + userExperienceDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserExperience)) return false;
        UserExperience that = (UserExperience) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getUserId().equals(that.getUserId()) &&
                getExperienceId().equals(that.getExperienceId()) &&
                getUserExperienceCreateAt().equals(that.getUserExperienceCreateAt()) &&
                getUserExperienceUpdateAt().equals(that.getUserExperienceUpdateAt()) &&
                getUserExperienceDeleteAt().equals(that.getUserExperienceDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getExperienceId(), getUserExperienceCreateAt(), getUserExperienceUpdateAt(), getUserExperienceDeleteAt(), getStatut());
    }
}
