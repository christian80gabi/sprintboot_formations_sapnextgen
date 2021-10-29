package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = {"role_label"}))
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_label")
    private String roleLabel;

    @Column(name = "role_description")
    private String roleDescription;

    @Column(name = "role_create_at")
    private Timestamp roleCreateAt;

    @Column(name = "role_update_at")
    private Timestamp roleUpdateAt;

    @Column(name = "role_delete_at")
    private Timestamp roleDeleteAt;

    @Column(name = "role_statut")
    private int statut;

    public Role() {
    }

    public Role(String roleLabel, String roleDescription, Timestamp roleCreateAt, Timestamp roleUpdateAt, Timestamp roleDeleteAt, int statut) {
        this.roleLabel = roleLabel;
        this.roleDescription = roleDescription;
        this.roleCreateAt = roleCreateAt;
        this.roleUpdateAt = roleUpdateAt;
        this.roleDeleteAt = roleDeleteAt;
        this.statut = statut;
    }

    public Role(Role role){
        this.id = role.id;
        this.roleLabel = role.roleLabel;
        this.roleDescription = role.roleDescription;
        this.roleCreateAt = role.roleCreateAt;
        this.roleUpdateAt = role.roleUpdateAt;
        this.roleDeleteAt = role.roleDeleteAt;
        this.statut = role.statut;
    }

    public long getId() {
        return id;
    }

    public String getRoleLabel() {
        return roleLabel;
    }

    public void setRoleLabel(String roleLabel) {
        this.roleLabel = roleLabel;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Timestamp getRoleCreateAt() {
        return roleCreateAt;
    }

    public void setRoleCreateAt(Timestamp roleCreateAt) {
        this.roleCreateAt = roleCreateAt;
    }

    public Timestamp getRoleUpdateAt() {
        return roleUpdateAt;
    }

    public void setRoleUpdateAt(Timestamp roleUpdateAt) {
        this.roleUpdateAt = roleUpdateAt;
    }

    public Timestamp getRoleDeleteAt() {
        return roleDeleteAt;
    }

    public void setRoleDeleteAt(Timestamp roleDeleteAt) {
        this.roleDeleteAt = roleDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleLabel='" + roleLabel + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", roleCreateAt=" + roleCreateAt +
                ", roleUpdateAt=" + roleUpdateAt +
                ", roleDeleteAt=" + roleDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return getId() == role.getId() &&
                getStatut() == role.getStatut() &&
                getRoleLabel().equals(role.getRoleLabel()) &&
                getRoleDescription().equals(role.getRoleDescription()) &&
                getRoleCreateAt().equals(role.getRoleCreateAt()) &&
                getRoleUpdateAt().equals(role.getRoleUpdateAt()) &&
                getRoleDeleteAt().equals(role.getRoleDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoleLabel(), getRoleDescription(), getRoleCreateAt(), getRoleUpdateAt(), getRoleDeleteAt(), getStatut());
    }
}
