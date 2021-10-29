package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_poste")
public class UserPoste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_poste_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste posteId;

    @Column(name = "user_poste_create_at")
    private Timestamp userPosteCreateAt;

    @Column(name = "user_poste_update_at")
    private Timestamp userPosteUpdateAt;

    @Column(name = "user_poste_delete_at")
    private Timestamp userPosteDeleteAt;

    @Column(name = "user_poste_statut")
    private int statut;

    public UserPoste() {
    }

    public UserPoste(User userId, Poste posteId, Timestamp userPosteCreateAt, Timestamp userPosteUpdateAt, Timestamp userPosteDeleteAt, int statut) {
        this.userId = userId;
        this.posteId = posteId;
        this.userPosteCreateAt = userPosteCreateAt;
        this.userPosteUpdateAt = userPosteUpdateAt;
        this.userPosteDeleteAt = userPosteDeleteAt;
        this.statut = statut;
    }

    public UserPoste(UserPoste userPoste) {
        this.id = userPoste.id;
        this.userId = userPoste.userId;
        this.posteId = userPoste.posteId;
        this.userPosteCreateAt = userPoste.userPosteCreateAt;
        this.userPosteUpdateAt = userPoste.userPosteUpdateAt;
        this.userPosteDeleteAt = userPoste.userPosteDeleteAt;
        this.statut = userPoste.statut;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Poste getPosteId() {
        return posteId;
    }

    public void setPosteId(Poste posteId) {
        this.posteId = posteId;
    }

    public Timestamp getUserPosteCreateAt() {
        return userPosteCreateAt;
    }

    public void setUserPosteCreateAt(Timestamp userPosteCreateAt) {
        this.userPosteCreateAt = userPosteCreateAt;
    }

    public Timestamp getUserPosteUpdateAt() {
        return userPosteUpdateAt;
    }

    public void setUserPosteUpdateAt(Timestamp userPosteUpdateAt) {
        this.userPosteUpdateAt = userPosteUpdateAt;
    }

    public Timestamp getUserPosteDeleteAt() {
        return userPosteDeleteAt;
    }

    public void setUserPosteDeleteAt(Timestamp userPosteDeleteAt) {
        this.userPosteDeleteAt = userPosteDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "UserPoste{" +
                "id=" + id +
                ", userId=" + userId +
                ", posteId=" + posteId +
                ", userPosteCreateAt=" + userPosteCreateAt +
                ", userPosteUpdateAt=" + userPosteUpdateAt +
                ", userPosteDeleteAt=" + userPosteDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPoste)) return false;
        UserPoste userPoste = (UserPoste) o;
        return id == userPoste.id &&
                getStatut() == userPoste.getStatut() &&
                getUserId().equals(userPoste.getUserId()) &&
                getPosteId().equals(userPoste.getPosteId()) &&
                getUserPosteCreateAt().equals(userPoste.getUserPosteCreateAt()) &&
                getUserPosteUpdateAt().equals(userPoste.getUserPosteUpdateAt()) &&
                getUserPosteDeleteAt().equals(userPoste.getUserPosteDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getUserId(), getPosteId(), getUserPosteCreateAt(), getUserPosteUpdateAt(), getUserPosteDeleteAt(), getStatut());
    }
}
