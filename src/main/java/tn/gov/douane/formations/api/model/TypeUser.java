package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "type_user", uniqueConstraints = @UniqueConstraint(name = "unique_type_user_libelle", columnNames = {"type_user_libelle"}))
public class TypeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_user_id")
    private long id;

    @Column(name = "type_user_libelle")
    private String typeUserLibelle;

    @Column(name = "type_user_description")
    private String typeUserDescription;

    @Column(name = "type_user_create_at")
    private Timestamp typeUserCreateAt;

    @Column(name = "type_user_update_at")
    private Timestamp typeUserUpdateAt;

    @Column(name = "type_user_delete_at")
    private Timestamp typeUserDeleteAt;

    @Column(name = "type_user_statut")
    private int statut;

    public TypeUser() {
    }

    public TypeUser(String typeUserLibelle, String typeUserDescription, Timestamp typeUserCreateAt, Timestamp typeUserUpdateAt, Timestamp typeUserDeleteAt, int statut) {
        this.typeUserLibelle = typeUserLibelle;
        this.typeUserDescription = typeUserDescription;
        this.typeUserCreateAt = typeUserCreateAt;
        this.typeUserUpdateAt = typeUserUpdateAt;
        this.typeUserDeleteAt = typeUserDeleteAt;
        this.statut = statut;
    }

    public TypeUser(TypeUser typeUser){
        this.id = typeUser.id;
        this.typeUserLibelle = typeUser.typeUserLibelle;
        this.typeUserDescription = typeUser.typeUserDescription;
        this.typeUserCreateAt = typeUser.typeUserCreateAt;
        this.typeUserUpdateAt = typeUser.typeUserUpdateAt;
        this.typeUserDeleteAt = typeUser.typeUserDeleteAt;
        this.statut = typeUser.statut;
    }

    public long getId() {
        return id;
    }

    public String getTypeUserLibelle() {
        return typeUserLibelle;
    }

    public void setTypeUserLibelle(String typeUserLibelle) {
        this.typeUserLibelle = typeUserLibelle;
    }

    public String getTypeUserDescription() {
        return typeUserDescription;
    }

    public void setTypeUserDescription(String typeUserDescription) {
        this.typeUserDescription = typeUserDescription;
    }

    public Timestamp getTypeUserCreateAt() {
        return typeUserCreateAt;
    }

    public void setTypeUserCreateAt(Timestamp typeUserCreateAt) {
        this.typeUserCreateAt = typeUserCreateAt;
    }

    public Timestamp getTypeUserUpdateAt() {
        return typeUserUpdateAt;
    }

    public void setTypeUserUpdateAt(Timestamp typeUserUpdateAt) {
        this.typeUserUpdateAt = typeUserUpdateAt;
    }

    public Timestamp getTypeUserDeleteAt() {
        return typeUserDeleteAt;
    }

    public void setTypeUserDeleteAt(Timestamp typeUserDeleteAt) {
        this.typeUserDeleteAt = typeUserDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "TypeUser{" +
                "id=" + id +
                ", typeUserLibelle='" + typeUserLibelle + '\'' +
                ", typeUserDescription='" + typeUserDescription + '\'' +
                ", typeUserCreateAt=" + typeUserCreateAt +
                ", typeUserUpdateAt=" + typeUserUpdateAt +
                ", typeUserDeleteAt=" + typeUserDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeUser)) return false;
        TypeUser typeUser = (TypeUser) o;
        return getId() == typeUser.getId() &&
                getStatut() == typeUser.getStatut() &&
                getTypeUserLibelle().equals(typeUser.getTypeUserLibelle()) &&
                getTypeUserDescription().equals(typeUser.getTypeUserDescription()) &&
                getTypeUserCreateAt().equals(typeUser.getTypeUserCreateAt()) &&
                getTypeUserUpdateAt().equals(typeUser.getTypeUserUpdateAt()) &&
                getTypeUserDeleteAt().equals(typeUser.getTypeUserDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTypeUserLibelle(), getTypeUserDescription(), getTypeUserCreateAt(), getTypeUserUpdateAt(), getTypeUserDeleteAt(), getStatut());
    }
}
