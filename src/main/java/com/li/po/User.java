package com.li.po;


import java.util.Date;

/**
 * 用户表实体
 */
public class User {
    private String userId;// VARCHAR(20) NOT NULL COMMENT '用户id',用户名
    private String userName;// VARCHAR(30) NOT NULL COMMENT '姓名',
    private String userPassword; //VARCHAR(20) NOT NULL COMMENT '用户密码',
    private String   userSex;// VARCHAR(1) NOT NULL COMMENT '性别',
    private Date userBirthday;// DATETIME// DEFAULT NULL COMMENT '出生日期',
    private String     userEmail; //VARCHAR(50) DEFAULT NULL COMMENT '电子邮箱',
    private String    userMobile;// VARCHAR(20) DEFAULT NULL COMMENT '电话',
    private String     userAddress; //VARCHAR(100) NOT NULL COMMENT '地址',
    private int    userStatus;// DECIMAL(6,0) NOT NULL COMMENT '权限1-普通2-管理',

    public User() {
    }

    public User(String userId, String userName, String userPassword, String userSex, Date userBirthday, String userEmail, String userMobile, String userAddress, int userStatus) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
        this.userStatus = userStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userEmail='" + userEmail + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
