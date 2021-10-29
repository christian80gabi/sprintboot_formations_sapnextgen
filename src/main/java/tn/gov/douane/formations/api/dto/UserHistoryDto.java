package tn.gov.douane.formations.api.dto;

import tn.gov.douane.formations.api.model.User;

public class UserHistoryDto {

    private int id;
    private Boolean userHistoryFlag;
    private int userId;
    private User user;

    public UserHistoryDto() {
    }

    public UserHistoryDto(int id, Boolean userHistoryFlag, int userId) {
        this.id = id;
        this.userHistoryFlag = userHistoryFlag;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getUserHistoryFlag() {
        return this.userHistoryFlag;
    }

    public void setUserHistoryFlag(Boolean userHistoryFlag) {
        this.userHistoryFlag = userHistoryFlag;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
