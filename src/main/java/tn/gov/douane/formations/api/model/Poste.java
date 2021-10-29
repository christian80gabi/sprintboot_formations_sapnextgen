package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "poste", uniqueConstraints = @UniqueConstraint(name = "unique_poste_code", columnNames = {"poste_code"}))
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poste_id")
    private long id;

    @Column(name = "poste_code")
    private String posteCode;

    @Column(name = "poste_label")
    private String posteLabel;

    @Column(name = "poste_description")
    private String posteDescription;

    @Column(name = "poste_create_at")
    private Timestamp posteCreateAt;

    @Column(name = "poste_update_at")
    private Timestamp posteUpdateAt;

    @Column(name = "poste_delete_at")
    private Timestamp posteDeleteAt;

    @Column(name = "poste_statut")
    private int statut;

    @ManyToOne
    @JoinColumn(name = "poste_statut_id")
    private PosteStatut posteStatutId;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade gradeId;

    public Poste() {
    }

    public Poste(String posteCode, String posteLabel, String posteDescription, Timestamp posteCreateAt, Timestamp posteUpdateAt, Timestamp posteDeleteAt, int statut) {
        this.posteCode = posteCode;
        this.posteLabel = posteLabel;
        this.posteDescription = posteDescription;
        this.posteCreateAt = posteCreateAt;
        this.posteUpdateAt = posteUpdateAt;
        this.posteDeleteAt = posteDeleteAt;
        this.statut = statut;
    }

    public Poste(Poste poste){
        this.id = poste.id;
        this.posteCode = poste.posteCode;
        this.posteLabel = poste.posteLabel;
        this.posteDescription = poste.posteDescription;
        this.posteCreateAt = poste.posteCreateAt;
        this.posteUpdateAt = poste.posteUpdateAt;
        this.posteDeleteAt = poste.posteDeleteAt;
        this.statut = poste.statut;
        this.posteStatutId = poste.posteStatutId;
        this.gradeId = poste.gradeId;
    }

    public long getId() {
        return id;
    }

    public String getPosteCode() {
        return posteCode;
    }

    public void setPosteCode(String posteCode) {
        this.posteCode = posteCode;
    }

    public String getPosteLabel() {
        return posteLabel;
    }

    public void setPosteLabel(String posteLabel) {
        this.posteLabel = posteLabel;
    }

    public String getPosteDescription() {
        return posteDescription;
    }

    public void setPosteDescription(String posteDescription) {
        this.posteDescription = posteDescription;
    }

    public Timestamp getPosteCreateAt() {
        return posteCreateAt;
    }

    public void setPosteCreateAt(Timestamp posteCreateAt) {
        this.posteCreateAt = posteCreateAt;
    }

    public Timestamp getPosteUpdateAt() {
        return posteUpdateAt;
    }

    public void setPosteUpdateAt(Timestamp posteUpdateAt) {
        this.posteUpdateAt = posteUpdateAt;
    }

    public Timestamp getPosteDeleteAt() {
        return posteDeleteAt;
    }

    public void setPosteDeleteAt(Timestamp posteDeleteAt) {
        this.posteDeleteAt = posteDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public PosteStatut getPosteStatutId() {
        return posteStatutId;
    }

    public void setPosteStatutId(PosteStatut posteStatutId) {
        this.posteStatutId = posteStatutId;
    }

    public Grade getGradeId() {
        return gradeId;
    }

    public void setGradeId(Grade gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "id=" + id +
                ", posteCode='" + posteCode + '\'' +
                ", posteLabel='" + posteLabel + '\'' +
                ", posteDescription='" + posteDescription + '\'' +
                ", posteCreateAt=" + posteCreateAt +
                ", posteUpdateAt=" + posteUpdateAt +
                ", posteDeleteAt=" + posteDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Poste)) return false;
        Poste poste = (Poste) o;
        return getId() == poste.getId() &&
                getStatut() == poste.getStatut() &&
                getPosteCode().equals(poste.getPosteCode()) &&
                getPosteLabel().equals(poste.getPosteLabel()) &&
                getPosteDescription().equals(poste.getPosteDescription()) &&
                getPosteCreateAt().equals(poste.getPosteCreateAt()) &&
                getPosteUpdateAt().equals(poste.getPosteUpdateAt()) &&
                getPosteDeleteAt().equals(poste.getPosteDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosteCode(), getPosteLabel(), getPosteDescription(), getPosteCreateAt(), getPosteUpdateAt(), getPosteDeleteAt(), getStatut());
    }
}
