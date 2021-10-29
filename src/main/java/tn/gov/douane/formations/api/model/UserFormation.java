package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_formation")
public class UserFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_formation_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formationId;

    @Column(name = "user_formation_create_at")
    private Timestamp userFormationCreateAt;

    @Column(name = "user_formation_update_at")
    private Timestamp userFormationUpdateAt;

    @Column(name = "user_formation_delete_at")
    private Timestamp userFormationDeleteAt;

    @Column(name = "user_formation_statut")
    private int statut;

    @Column(name = "user_formation_note")
    private double note;

    public UserFormation() {
    }

    public UserFormation(long id) {
        this.id = id;
    }


    public UserFormation(User userId, Formation formationId, Timestamp userFormationCreateAt, Timestamp userFormationUpdateAt, Timestamp userFormationDeleteAt, int statut) {
        this.userId = userId;
        this.formationId = formationId;
        this.userFormationCreateAt = userFormationCreateAt;
        this.userFormationUpdateAt = userFormationUpdateAt;
        this.userFormationDeleteAt = userFormationDeleteAt;
        this.statut = statut;
    }

    public UserFormation(UserFormation userFormation) {
        this.id = userFormation.id;
        this.userId = userFormation.userId;
        this.formationId = userFormation.formationId;
        this.userFormationCreateAt = userFormation.userFormationCreateAt;
        this.userFormationUpdateAt = userFormation.userFormationUpdateAt;
        this.userFormationDeleteAt = userFormation.userFormationDeleteAt;
        this.statut = userFormation.statut;
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

    public Formation getFormationId() {
        return formationId;
    }

    public void setFormationId(Formation formationId) {
        this.formationId = formationId;
    }

    public Timestamp getUserFormationCreateAt() {
        return userFormationCreateAt;
    }

    public void setUserFormationCreateAt(Timestamp userFormationCreateAt) {
        this.userFormationCreateAt = userFormationCreateAt;
    }

    public Timestamp getUserFormationUpdateAt() {
        return userFormationUpdateAt;
    }

    public void setUserFormationUpdateAt(Timestamp userFormationUpdateAt) {
        this.userFormationUpdateAt = userFormationUpdateAt;
    }

    public Timestamp getUserFormationDeleteAt() {
        return userFormationDeleteAt;
    }

    public void setUserFormationDeleteAt(Timestamp userFormationDeleteAt) {
        this.userFormationDeleteAt = userFormationDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "UserFormation{" +
                "id=" + id +
                ", userId=" + userId +
                ", formationId=" + formationId +
                ", userFormationCreateAt=" + userFormationCreateAt +
                ", userFormationUpdateAt=" + userFormationUpdateAt +
                ", userFormationDeleteAt=" + userFormationDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserFormation)) return false;
        UserFormation that = (UserFormation) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                Double.compare(that.getNote(), getNote()) == 0 &&
                getUserId().equals(that.getUserId()) &&
                getFormationId().equals(that.getFormationId()) &&
                getUserFormationCreateAt().equals(that.getUserFormationCreateAt()) &&
                getUserFormationUpdateAt().equals(that.getUserFormationUpdateAt()) &&
                getUserFormationDeleteAt().equals(that.getUserFormationDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getFormationId(), getUserFormationCreateAt(), getUserFormationUpdateAt(), getUserFormationDeleteAt(), getStatut(), getNote());
    }
}
