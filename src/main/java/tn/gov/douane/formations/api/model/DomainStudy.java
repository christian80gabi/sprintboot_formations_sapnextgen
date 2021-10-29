package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "domain_study", uniqueConstraints = @UniqueConstraint(name = "unique_domain_study_label", columnNames = {"domain_study_label"}))
public class DomainStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_study_id")
    private long id;

    @Column(name = "domain_study_label")
    private String domainStudyLabel;

    @Column(name = "domain_study_create_at")
    private Timestamp domainStudyCreateAt;

    @Column(name = "domain_study_update_at")
    private Timestamp domainStudyUpdateAt;

    @Column(name = "domain_study_delete_at")
    private Timestamp domainStudyDeleteAt;

    @Column(name = "domain_study_statut")
    private int statut;

    public DomainStudy() {
    }

    public DomainStudy(String domainStudyLabel, Timestamp domainStudyCreateAt, Timestamp domainStudyUpdateAt, Timestamp domainStudyDeleteAt, int statut) {
        this.domainStudyLabel = domainStudyLabel;
        this.domainStudyCreateAt = domainStudyCreateAt;
        this.domainStudyUpdateAt = domainStudyUpdateAt;
        this.domainStudyDeleteAt = domainStudyDeleteAt;
        this.statut = statut;
    }

    public DomainStudy(DomainStudy domain) {
        this.id = domain.id;
        this.domainStudyLabel = domain.domainStudyLabel;
        this.domainStudyCreateAt = domain.domainStudyCreateAt;
        this.domainStudyUpdateAt = domain.domainStudyUpdateAt;
        this.domainStudyDeleteAt = domain.domainStudyDeleteAt;
        this.statut = domain.statut;
    }

    public long getId() {
        return id;
    }

    public String getDomainStudyLabel() {
        return domainStudyLabel;
    }

    public void setDomainStudyLabel(String domainStudyLabel) {
        this.domainStudyLabel = domainStudyLabel;
    }

    public Timestamp getDomainStudyCreateAt() {
        return domainStudyCreateAt;
    }

    public void setDomainStudyCreateAt(Timestamp domainStudyCreateAt) {
        this.domainStudyCreateAt = domainStudyCreateAt;
    }

    public Timestamp getDomainStudyUpdateAt() {
        return domainStudyUpdateAt;
    }

    public void setDomainStudyUpdateAt(Timestamp domainStudyUpdateAt) {
        this.domainStudyUpdateAt = domainStudyUpdateAt;
    }

    public Timestamp getDomainStudyDeleteAt() {
        return domainStudyDeleteAt;
    }

    public void setDomainStudyDeleteAt(Timestamp domainStudyDeleteAt) {
        this.domainStudyDeleteAt = domainStudyDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "DomainStudy{" +
                "id=" + id +
                ", domainStudyLabel='" + domainStudyLabel + '\'' +
                ", domainStudyCreateAt=" + domainStudyCreateAt +
                ", domainStudyUpdateAt=" + domainStudyUpdateAt +
                ", domainStudyDeleteAt=" + domainStudyDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomainStudy)) return false;
        DomainStudy that = (DomainStudy) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getDomainStudyLabel().equals(that.getDomainStudyLabel()) &&
                getDomainStudyCreateAt().equals(that.getDomainStudyCreateAt()) &&
                getDomainStudyUpdateAt().equals(that.getDomainStudyUpdateAt()) &&
                getDomainStudyDeleteAt().equals(that.getDomainStudyDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDomainStudyLabel(), getDomainStudyCreateAt(), getDomainStudyUpdateAt(), getDomainStudyDeleteAt(), getStatut());
    }
}
