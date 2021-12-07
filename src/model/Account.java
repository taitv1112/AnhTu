package model;

import java.io.Serializable;
/*
Acc có acc nhân viên
acc khách = guest. tên khách
pass khách = guest.sđt
 */
public class Account implements Serializable {
    private String userName;
    private String passUser;
    private Guest guest;
    private String role;
    public static final String STAFF = "STAFF";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public Guest getGuest() {
        return guest;
    }
    private boolean check;

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account() {
    }

    public Account(String userName, String passUser) {
        this.userName = userName;
        this.passUser = passUser;
    }

    public Account(String userName, String passUser, Guest guest) {
        this.userName = userName;
        this.passUser = passUser;
        this.guest = guest;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", passUser='" + passUser + '\'' +
                ", guest=" + guest +
                ", role='" + role + '\'' +
                ", check=" + check +
                '}';
    }
}
