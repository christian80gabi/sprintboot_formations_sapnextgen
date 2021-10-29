package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.TypeUser;

public class UserDto {

    private int id;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private String userMatricule;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userPhoto;
    private int typeUserId;
    private TypeUser typeUser;

    public UserDto() {
    }

    public UserDto(int id, String userEmail, String userFirstName, String userLastName, String userMatricule, String userName, String userPassword,
                   String userPhone, String userPhoto, int typeUserId) {
        this.id = id;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userMatricule = userMatricule;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userPhoto = userPhoto;
        this.typeUserId = typeUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserMatricule() {
        return this.userMatricule;
    }

    public void setUserMatricule(String userMatricule) {
        this.userMatricule = userMatricule;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPhoto() {
        return this.userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public int getTypeUserId() {
        return this.typeUserId;
    }

    public void setTypeUserId(int typeUserId) {
        this.typeUserId = typeUserId;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }
}
