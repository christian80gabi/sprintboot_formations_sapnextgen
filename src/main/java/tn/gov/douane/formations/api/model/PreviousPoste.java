package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "previous_poste")
public class PreviousPoste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "previous_poste_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste posteId;

    @ManyToOne
    @JoinColumn(name = "poste_previous_id")
    private Poste postePreviousId;

    @Column(name = "previous_poste_create_at")
    private Timestamp previousPosteCreateAt;

    @Column(name = "previous_poste_update_at")
    private Timestamp previousPosteUpdateAt;

    @Column(name = "previous_poste_delete_at")
    private Timestamp previousPosteDeleteAt;

    @Column(name = "previous_poste_statut")
    private int statut;

    public PreviousPoste() {
    }

    public PreviousPoste(Poste posteId, Poste postePreviousId, Timestamp previousPosteCreateAt, Timestamp previousPosteUpdateAt, Timestamp previousPosteDeleteAt, int statut) {
        this.posteId = posteId;
        this.postePreviousId = postePreviousId;
        this.previousPosteCreateAt = previousPosteCreateAt;
        this.previousPosteUpdateAt = previousPosteUpdateAt;
        this.previousPosteDeleteAt = previousPosteDeleteAt;
        this.statut = statut;
    }

    public PreviousPoste(PreviousPoste previousPoste) {
        this.id = previousPoste.id;
        this.posteId = previousPoste.posteId;
        this.postePreviousId = previousPoste.postePreviousId;
        this.previousPosteCreateAt = previousPoste.previousPosteCreateAt;
        this.previousPosteUpdateAt = previousPoste.previousPosteUpdateAt;
        this.previousPosteDeleteAt = previousPoste.previousPosteDeleteAt;
        this.statut = previousPoste.statut;
    }

    public long getId() {
        return id;
    }

    public Poste getPosteId() {
        return posteId;
    }

    public void setPosteId(Poste posteId) {
        this.posteId = posteId;
    }

    public Poste getPostePreviousId() {
        return postePreviousId;
    }

    public void setPostePreviousId(Poste postePreviousId) {
        this.postePreviousId = postePreviousId;
    }

    public Timestamp getPreviousPosteCreateAt() {
        return previousPosteCreateAt;
    }

    public void setPreviousPosteCreateAt(Timestamp previousPosteCreateAt) {
        this.previousPosteCreateAt = previousPosteCreateAt;
    }

    public Timestamp getPreviousPosteUpdateAt() {
        return previousPosteUpdateAt;
    }

    public void setPreviousPosteUpdateAt(Timestamp previousPosteUpdateAt) {
        this.previousPosteUpdateAt = previousPosteUpdateAt;
    }

    public Timestamp getPreviousPosteDeleteAt() {
        return previousPosteDeleteAt;
    }

    public void setPreviousPosteDeleteAt(Timestamp previousPosteDeleteAt) {
        this.previousPosteDeleteAt = previousPosteDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "PreviousPoste{" +
                "id=" + id +
                ", posteId=" + posteId +
                ", postePreviousId=" + postePreviousId +
                ", previousPosteCreateAt=" + previousPosteCreateAt +
                ", previousPosteUpdateAt=" + previousPosteUpdateAt +
                ", previousPosteDeleteAt=" + previousPosteDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreviousPoste)) return false;
        PreviousPoste that = (PreviousPoste) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getPosteId().equals(that.getPosteId()) &&
                getPostePreviousId().equals(that.getPostePreviousId()) &&
                getPreviousPosteCreateAt().equals(that.getPreviousPosteCreateAt()) &&
                getPreviousPosteUpdateAt().equals(that.getPreviousPosteUpdateAt()) &&
                getPreviousPosteDeleteAt().equals(that.getPreviousPosteDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosteId(), getPostePreviousId(), getPreviousPosteCreateAt(), getPreviousPosteUpdateAt(), getPreviousPosteDeleteAt(), getStatut());
    }
}
