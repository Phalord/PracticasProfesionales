package com.standardeleven.project.logical;

public class User {
    private String userName;
    private String userPassword;
    private String userType;

    public User(){}

    public User(String userName, String userPassword, String userType) {
        this.setUserName(userName);
        this.setUserPassword(userPassword);
        this.setUserType(userType);
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", userPassword=" + userPassword + ", userType=" + userType + '}';
    }
}
