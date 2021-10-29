package tn.gov.douane.formations.api.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_name", "user_email", "user_phone"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_matricule")
    private String userMatricule;

    @Column(name = "user_first_name")
    private String userFirstName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_photo")
    private String userPhoto;

    @Column(name = "user_create_at")
    private Timestamp userCreateAt;

    @Column(name = "user_update_at")
    private Timestamp userUpdateAt;

    @Column(name = "user_delete_at")
    private Timestamp userDeleteAt;

    @Column(name = "user_statut")
    private int userStatut;

    @ManyToOne
    @JoinColumn(name = "type_user_id")
    private TypeUser typeUserId;

    public User() {
    }

    public User(String userMatricule, String userFirstName, String userLastName, String userName, String userPassword, String userEmail, String userPhone, String userPhoto, Timestamp userCreateAt, Timestamp userUpdateAt, Timestamp userDeleteAt, int userStatut, TypeUser typeUserId) {
        this.userMatricule = userMatricule;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPhoto = userPhoto;
        this.userCreateAt = userCreateAt;
        this.userUpdateAt = userUpdateAt;
        this.userDeleteAt = userDeleteAt;
        this.userStatut = userStatut;
        this.typeUserId = typeUserId;
    }

    public User(User user){
        this.id = user.id;
        this.userMatricule = user.userMatricule;
        this.userFirstName = user.userFirstName;
        this.userLastName = user.userLastName;
        this.userName = user.userName;
        this.userPassword = user.userPassword;
        this.userEmail = user.userEmail;
        this.userPhone = user.userPhone;
        this.userPhoto = user.userPhoto;
        this.userCreateAt = user.userCreateAt;
        this.userUpdateAt = user.userUpdateAt;
        this.userDeleteAt = user.userDeleteAt;
        this.userStatut = user.userStatut;
        this.typeUserId = user.typeUserId;
    }

    public long getId() {
        return id;
    }

    public String getUserMatricule() {
        return userMatricule;
    }

    public void setUserMatricule(String userMatricule) {
        this.userMatricule = userMatricule;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Timestamp getUserCreateAt() {
        return userCreateAt;
    }

    public void setUserCreateAt(Timestamp userCreateAt) {
        this.userCreateAt = userCreateAt;
    }

    public Timestamp getUserUpdateAt() {
        return userUpdateAt;
    }

    public void setUserUpdateAt(Timestamp userUpdateAt) {
        this.userUpdateAt = userUpdateAt;
    }

    public Timestamp getUserDeleteAt() {
        return userDeleteAt;
    }

    public void setUserDeleteAt(Timestamp userDeleteAt) {
        this.userDeleteAt = userDeleteAt;
    }

    public int getUserStatut() {
        return userStatut;
    }

    public void setUserStatut(int userStatut) {
        this.userStatut = userStatut;
    }

    public TypeUser getTypeUserId() {
        return typeUserId;
    }

    public void setTypeUserId(TypeUser typeUserId) {
        this.typeUserId = typeUserId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userMatricule='" + userMatricule + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userCreateAt=" + userCreateAt +
                ", userUpdateAt=" + userUpdateAt +
                ", userDeleteAt=" + userDeleteAt +
                ", userStatut=" + userStatut +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getUserStatut() == user.getUserStatut() &&
                getUserMatricule().equals(user.getUserMatricule()) &&
                getUserFirstName().equals(user.getUserFirstName()) &&
                getUserLastName().equals(user.getUserLastName()) &&
                getUserName().equals(user.getUserName()) &&
                getUserPassword().equals(user.getUserPassword()) &&
                getUserEmail().equals(user.getUserEmail()) &&
                getUserPhone().equals(user.getUserPhone()) &&
                getUserPhoto().equals(user.getUserPhoto()) &&
                getUserCreateAt().equals(user.getUserCreateAt()) &&
                getUserUpdateAt().equals(user.getUserUpdateAt()) &&
                getUserDeleteAt().equals(user.getUserDeleteAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserMatricule(), getUserFirstName(), getUserLastName(), getUserName(), getUserPassword(), getUserEmail(), getUserPhone(), getUserPhoto(), getUserCreateAt(), getUserUpdateAt(), getUserDeleteAt(), getUserStatut());
    }
}
