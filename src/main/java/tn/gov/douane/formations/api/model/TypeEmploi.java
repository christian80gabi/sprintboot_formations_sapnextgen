package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "type_emploi", uniqueConstraints = @UniqueConstraint(name = "unique_type_emp_libelle", columnNames = {"type_emp_libelle"}))
public class TypeEmploi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_emp_id")
    private long id;

    @Column(name = "type_emp_libelle")
    private String typeEmploiLibelle;

    @Column(name = "type_emp_description")
    private String typeEmploiDescription;

    @Column(name = "type_emp_create_at")
    private Timestamp typeEmploiCreateAt;

    @Column(name = "type_emp_update_at")
    private Timestamp typeEmploiUpdateAt;

    @Column(name = "type_emp_delete_at")
    private Timestamp typeEmploiDeleteAt;

    @Column(name = "type_emp_statut")
    private int statut;

    public TypeEmploi() {
    }

    public TypeEmploi(String typeEmploiLibelle, String typeEmploiDescription, Timestamp typeEmploiCreateAt,
                      Timestamp typeEmploiUpdateAt, Timestamp typeEmploiDeleteAt, int statut) {
        this.typeEmploiLibelle = typeEmploiLibelle;
        this.typeEmploiDescription = typeEmploiDescription;
        this.typeEmploiCreateAt = typeEmploiCreateAt;
        this.typeEmploiUpdateAt = typeEmploiUpdateAt;
        this.typeEmploiDeleteAt = typeEmploiDeleteAt;
        this.statut = statut;
    }

    public TypeEmploi(TypeEmploi typeEmploi) {
        this.id = typeEmploi.id;
        this.typeEmploiLibelle = typeEmploi.typeEmploiLibelle;
        this.typeEmploiDescription = typeEmploi.typeEmploiDescription;
        this.typeEmploiCreateAt = typeEmploi.typeEmploiCreateAt;
        this.typeEmploiUpdateAt = typeEmploi.typeEmploiUpdateAt;
        this.typeEmploiDeleteAt = typeEmploi.typeEmploiDeleteAt;
        this.statut = typeEmploi.statut;
    }

    public long getId() {
        return id;
    }

    public String getTypeEmploiLibelle() {
        return typeEmploiLibelle;
    }

    public void setTypeEmploiLibelle(String typeEmploiLibelle) {
        this.typeEmploiLibelle = typeEmploiLibelle;
    }

    public String getTypeEmploiDescription() {
        return typeEmploiDescription;
    }

    public void setTypeEmploiDescription(String typeEmploiDescription) {
        this.typeEmploiDescription = typeEmploiDescription;
    }

    public Timestamp getTypeEmploiCreateAt() {
        return typeEmploiCreateAt;
    }

    public void setTypeEmploiCreateAt(Timestamp typeEmploiCreateAt) {
        this.typeEmploiCreateAt = typeEmploiCreateAt;
    }

    public Timestamp getTypeEmploiUpdateAt() {
        return typeEmploiUpdateAt;
    }

    public void setTypeEmploiUpdateAt(Timestamp typeEmploiUpdateAt) {
        this.typeEmploiUpdateAt = typeEmploiUpdateAt;
    }

    public Timestamp getTypeEmploiDeleteAt() {
        return typeEmploiDeleteAt;
    }

    public void setTypeEmploiDeleteAt(Timestamp typeEmploiDeleteAt) {
        this.typeEmploiDeleteAt = typeEmploiDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "TypeEmploi{" +
                "id=" + id +
                ", typeEmploiLibelle='" + typeEmploiLibelle + '\'' +
                ", typeEmploiDescription='" + typeEmploiDescription + '\'' +
                ", typeEmploiCreateAt=" + typeEmploiCreateAt +
                ", typeEmploiUpdateAt=" + typeEmploiUpdateAt +
                ", typeEmploiDeleteAt=" + typeEmploiDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeEmploi)) return false;
        TypeEmploi that = (TypeEmploi) o;
        return getId() == that.getId() &&
                getStatut() == that.getStatut() &&
                getTypeEmploiLibelle().equals(that.getTypeEmploiLibelle()) &&
                getTypeEmploiDescription().equals(that.getTypeEmploiDescription()) &&
                getTypeEmploiCreateAt().equals(that.getTypeEmploiCreateAt()) &&
                getTypeEmploiUpdateAt().equals(that.getTypeEmploiUpdateAt()) &&
                getTypeEmploiDeleteAt().equals(that.getTypeEmploiDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeEmploiLibelle(), getTypeEmploiDescription(), getTypeEmploiCreateAt(), getTypeEmploiUpdateAt(), getTypeEmploiDeleteAt(), getStatut());
    }
}
