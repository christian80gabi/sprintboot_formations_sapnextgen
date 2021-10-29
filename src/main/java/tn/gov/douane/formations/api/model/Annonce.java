package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "annonce")
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "annonce_id")
    private long id;

    @Column(name = "annonce_label")
    private String annonceLabel;

    @Column(name = "annonce_description")
    private String annonceDescription;

    @Column(name = "annonce_create_at")
    private Timestamp annonceCreateAt;

    @Column(name = "annonce_update_at")
    private Timestamp annonceUpdateAt;

    @Column(name = "annonce_delete_at")
    private Timestamp annonceDeleteAt;

    @Column(name = "annonce_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "poste_id")
    private Poste posteId;

    public Annonce() {
    }

    public Annonce(String annonceLabel, String annonceDescription, Timestamp annonceCreateAt,
                   Timestamp annonceUpdateAt, Timestamp annonceDeleteAt, int statut) {
        this.annonceLabel = annonceLabel;
        this.annonceDescription = annonceDescription;
        this.annonceCreateAt = annonceCreateAt;
        this.annonceUpdateAt = annonceUpdateAt;
        this.annonceDeleteAt = annonceDeleteAt;
        this.statut = statut;
    }

    public Annonce(Annonce annonce) {
        this.id = annonce.id;
        this.annonceLabel = annonce.annonceLabel;
        this.annonceDescription = annonce.annonceDescription;
        this.annonceCreateAt = annonce.annonceCreateAt;
        this.annonceUpdateAt = annonce.annonceUpdateAt;
        this.annonceDeleteAt = annonce.annonceDeleteAt;
        this.statut = annonce.statut;
        this.posteId = annonce.posteId;
    }

    public long getId() {
        return id;
    }

    public String getAnnonceLabel() {
        return annonceLabel;
    }

    public void setAnnonceLabel(String annonceLabel) {
        this.annonceLabel = annonceLabel;
    }

    public String getAnnonceDescription() {
        return annonceDescription;
    }

    public void setAnnonceDescription(String annonceDescription) {
        this.annonceDescription = annonceDescription;
    }

    public Timestamp getAnnonceCreateAt() {
        return annonceCreateAt;
    }

    public void setAnnonceCreateAt(Timestamp annonceCreateAt) {
        this.annonceCreateAt = annonceCreateAt;
    }

    public Timestamp getAnnonceUpdateAt() {
        return annonceUpdateAt;
    }

    public void setAnnonceUpdateAt(Timestamp annonceUpdateAt) {
        this.annonceUpdateAt = annonceUpdateAt;
    }

    public Timestamp getAnnonceDeleteAt() {
        return annonceDeleteAt;
    }

    public void setAnnonceDeleteAt(Timestamp annonceDeleteAt) {
        this.annonceDeleteAt = annonceDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Poste getPosteId() {
        return posteId;
    }

    public void setPosteId(Poste posteId) {
        this.posteId = posteId;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "id=" + id +
                ", annonceLabel='" + annonceLabel + '\'' +
                ", annonceDescription='" + annonceDescription + '\'' +
                ", annonceCreateAt=" + annonceCreateAt +
                ", annonceUpdateAt=" + annonceUpdateAt +
                ", annonceDeleteAt=" + annonceDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Annonce)) return false;
        Annonce annonce = (Annonce) o;
        return getId() == annonce.getId() &&
                getStatut() == annonce.getStatut() &&
                getAnnonceLabel().equals(annonce.getAnnonceLabel()) &&
                getAnnonceDescription().equals(annonce.getAnnonceDescription()) &&
                getAnnonceCreateAt().equals(annonce.getAnnonceCreateAt()) &&
                getAnnonceUpdateAt().equals(annonce.getAnnonceUpdateAt()) &&
                getAnnonceDeleteAt().equals(annonce.getAnnonceDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAnnonceLabel(), getAnnonceDescription(), getAnnonceCreateAt(), getAnnonceUpdateAt(), getAnnonceDeleteAt(), getStatut());
    }
}
