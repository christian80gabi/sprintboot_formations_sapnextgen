package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;

    @Column(name = "user_role_create_at")
    private Timestamp userRoleCreateAt;

    @Column(name = "user_role_update_at")
    private Timestamp userRoleUpdateAt;

    @Column(name = "user_role_delete_at")
    private Timestamp userRoleDeleteAt;

    @Column(name = "user_role_statut")
    private int statut;

    public UserRole() {
    }

    public UserRole(User userId, Role roleId, Timestamp userRoleCreateAt, Timestamp userRoleUpdateAt, Timestamp userRoleDeleteAt, int statut) {
        this.userId = userId;
        this.roleId = roleId;
        this.userRoleCreateAt = userRoleCreateAt;
        this.userRoleUpdateAt = userRoleUpdateAt;
        this.userRoleDeleteAt = userRoleDeleteAt;
        this.statut = statut;
    }

    public UserRole(UserRole userRole) {
        this.id = userRole.id;
        this.userId = userRole.userId;
        this.roleId = userRole.roleId;
        this.userRoleCreateAt = userRole.userRoleCreateAt;
        this.userRoleUpdateAt = userRole.userRoleUpdateAt;
        this.userRoleDeleteAt = userRole.userRoleDeleteAt;
        this.statut = userRole.statut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Timestamp getUserRoleCreateAt() {
        return userRoleCreateAt;
    }

    public void setUserRoleCreateAt(Timestamp userRoleCreateAt) {
        this.userRoleCreateAt = userRoleCreateAt;
    }

    public Timestamp getUserRoleUpdateAt() {
        return userRoleUpdateAt;
    }

    public void setUserRoleUpdateAt(Timestamp userRoleUpdateAt) {
        this.userRoleUpdateAt = userRoleUpdateAt;
    }

    public Timestamp getUserRoleDeleteAt() {
        return userRoleDeleteAt;
    }

    public void setUserRoleDeleteAt(Timestamp userRoleDeleteAt) {
        this.userRoleDeleteAt = userRoleDeleteAt;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + userId +
                ", role=" + roleId +
                ", userRoleCreateAt=" + userRoleCreateAt +
                ", userRoleUpdateAt=" + userRoleUpdateAt +
                ", userRoleDeleteAt=" + userRoleDeleteAt +
                ", statut=" + statut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;
        UserRole userRole = (UserRole) o;
        return getId() == userRole.getId() &&
                getStatut() == userRole.getStatut() &&
                getUserId().equals(userRole.getUserId()) &&
                getRoleId().equals(userRole.getRoleId()) &&
                getUserRoleCreateAt().equals(userRole.getUserRoleCreateAt()) &&
                getUserRoleUpdateAt().equals(userRole.getUserRoleUpdateAt()) &&
                getUserRoleDeleteAt().equals(userRole.getUserRoleDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserId(), getRoleId(), getUserRoleCreateAt(), getUserRoleUpdateAt(), getUserRoleDeleteAt(), getStatut());
    }
}
