package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_history")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_history_id")
    private long id;

    @Column(name = "user_history_ip_adress")
    private String userHistoryIpAdress;

    @Column(name = "user_history_flag")
    private boolean userHistoryFlag;

    @Column(name = "user_history_create_at")
    private Timestamp userHistoryCreateAt;

    @Column(name = "user_history_update_at")
    private Timestamp userHistoryUpdateAt;

    @Column(name = "user_history_delete_at")
    private Timestamp userHistoryDeleteAt;

    @Column(name = "user_history_statut")
    private int userHistoryStatut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    public UserHistory() {
    }

    public UserHistory(String userHistoryIpAdress, boolean userHistoryFlag,
                       Timestamp userHistoryCreateAt, Timestamp userHistoryUpdateAt, Timestamp userHistoryDeleteAt,
                       int userHistoryStatut, User userId) {
        this.userHistoryIpAdress = userHistoryIpAdress;
        this.userHistoryFlag = userHistoryFlag;
        this.userHistoryCreateAt = userHistoryCreateAt;
        this.userHistoryUpdateAt = userHistoryUpdateAt;
        this.userHistoryDeleteAt = userHistoryDeleteAt;
        this.userHistoryStatut = userHistoryStatut;
        this.userId = userId;
    }

    public UserHistory(UserHistory userHistory){
        this.id = userHistory.id;
        this.userHistoryIpAdress = userHistory.userHistoryIpAdress;
        this.userHistoryFlag = userHistory.userHistoryFlag;
        this.userHistoryCreateAt = userHistory.userHistoryCreateAt;
        this.userHistoryUpdateAt = userHistory.userHistoryUpdateAt;
        this.userHistoryDeleteAt = userHistory.userHistoryDeleteAt;
        this.userHistoryStatut = userHistory.userHistoryStatut;
        this.userId = userHistory.userId;
    }

    public long getId() {
        return id;
    }

    public String getUserHistoryIpAdress() {
        return userHistoryIpAdress;
    }

    public void setUserHistoryIpAdress(String userHistoryIpAdress) {
        this.userHistoryIpAdress = userHistoryIpAdress;
    }

    public boolean isUserHistoryFlag() {
        return userHistoryFlag;
    }

    public void setUserHistoryFlag(boolean userHistoryFlag) {
        this.userHistoryFlag = userHistoryFlag;
    }

    public Timestamp getUserHistoryCreateAt() {
        return userHistoryCreateAt;
    }

    public void setUserHistoryCreateAt(Timestamp userHistoryCreateAt) {
        this.userHistoryCreateAt = userHistoryCreateAt;
    }

    public Timestamp getUserHistoryUpdateAt() {
        return userHistoryUpdateAt;
    }

    public void setUserHistoryUpdateAt(Timestamp userHistoryUpdateAt) {
        this.userHistoryUpdateAt = userHistoryUpdateAt;
    }

    public Timestamp getUserHistoryDeleteAt() {
        return userHistoryDeleteAt;
    }

    public void setUserHistoryDeleteAt(Timestamp userHistoryDeleteAt) {
        this.userHistoryDeleteAt = userHistoryDeleteAt;
    }

    public int getUserHistoryStatut() {
        return userHistoryStatut;
    }

    public void setUserHistoryStatut(int userHistoryStatut) {
        this.userHistoryStatut = userHistoryStatut;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "id=" + id +
                ", userHistoryIpAdress='" + userHistoryIpAdress + '\'' +
                ", userHistoryFlag=" + userHistoryFlag +
                ", userHistoryCreateAt=" + userHistoryCreateAt +
                ", userHistoryUpdateAt=" + userHistoryUpdateAt +
                ", userHistoryDeleteAt=" + userHistoryDeleteAt +
                ", userHistoryStatut=" + userHistoryStatut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHistory)) return false;
        UserHistory that = (UserHistory) o;
        return getId() == that.getId() &&
                isUserHistoryFlag() == that.isUserHistoryFlag() &&
                getUserHistoryStatut() == that.getUserHistoryStatut() &&
                getUserHistoryIpAdress().equals(that.getUserHistoryIpAdress()) &&
                getUserHistoryCreateAt().equals(that.getUserHistoryCreateAt()) &&
                getUserHistoryUpdateAt().equals(that.getUserHistoryUpdateAt()) &&
                getUserHistoryDeleteAt().equals(that.getUserHistoryDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserHistoryIpAdress(), isUserHistoryFlag(), getUserHistoryCreateAt(), getUserHistoryUpdateAt(), getUserHistoryDeleteAt(), getUserHistoryStatut());
    }
}
