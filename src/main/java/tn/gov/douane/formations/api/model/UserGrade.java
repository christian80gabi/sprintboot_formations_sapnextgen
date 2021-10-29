package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_grade")
public class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_grade_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade gradeId;

    @Column(name = "user_grade_create_at")
    private Timestamp userGradeCreateAt;

    @Column(name = "user_grade_update_at")
    private Timestamp userGradeUpdateAt;

    @Column(name = "user_grade_delete_at")
    private Timestamp userGradeDeleteAt;

    @Column(name = "user_grade_statut")
    private int statut;

    public UserGrade() {
    }

    public UserGrade(User userId, Grade gradeId, Timestamp userGradeCreateAt,
                     Timestamp userGradeUpdateAt, Timestamp userGradeDeleteAt, int statut) {
        this.userId = userId;
        this.gradeId = gradeId;
        this.userGradeCreateAt = userGradeCreateAt;
        this.userGradeUpdateAt = userGradeUpdateAt;
        this.userGradeDeleteAt = userGradeDeleteAt;
        this.statut = statut;
    }

    public UserGrade(UserGrade userGrade) {
        this.id = userGrade.id;
        this.userId = userGrade.userId;
        this.gradeId = userGrade.gradeId;
        this.userGradeCreateAt = userGrade.userGradeCreateAt;
        this.userGradeUpdateAt = userGrade.userGradeUpdateAt;
        this.userGradeDeleteAt = userGrade.userGradeDeleteAt;
        this.statut = userGrade.statut;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Grade getGradeId() {
        return gradeId;
    }

    public void setGradeId(Grade gradeId) {
        this.gradeId = gradeId;
    }

    public Timestamp getUserGradeCreateAt() {
        return userGradeCreateAt;
    }

    public void setUserGradeCreateAt(Timestamp userGradeCreateAt) {
        this.userGradeCreateAt = userGradeCreateAt;
    }

    public Timestamp getUserGradeUpdateAt() {
        return userGradeUpdateAt;
    }

    public void setUserGradeUpdateAt(Timestamp userGradeUpdateAt) {
        this.userGradeUpdateAt = userGradeUpdateAt;
    }

    public Timestamp getUserGradeDeleteAt() {
        return userGradeDeleteAt;
    }

    public void setUserGradeDeleteAt(Timestamp userGradeDeleteAt) {
        this.userGradeDeleteAt = userGradeDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "UserGrade{" +
                "id=" + id +
                ", userId=" + userId +
                ", gradeId=" + gradeId +
                ", userGradeCreateAt=" + userGradeCreateAt +
                ", userGradeUpdateAt=" + userGradeUpdateAt +
                ", userGradeDeleteAt=" + userGradeDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserGrade)) return false;
        UserGrade userGrade = (UserGrade) o;
        return id == userGrade.id &&
                getStatut() == userGrade.getStatut() &&
                getUserId().equals(userGrade.getUserId()) &&
                getGradeId().equals(userGrade.getGradeId()) &&
                getUserGradeCreateAt().equals(userGrade.getUserGradeCreateAt()) &&
                getUserGradeUpdateAt().equals(userGrade.getUserGradeUpdateAt()) &&
                getUserGradeDeleteAt().equals(userGrade.getUserGradeDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getUserId(), getGradeId(), getUserGradeCreateAt(), getUserGradeUpdateAt(), getUserGradeDeleteAt(), getStatut());
    }
}
