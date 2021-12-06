package model;

import java.io.Serializable;

public class Account implements Serializable {
    private String adminName;
    private String passAdmin;
    private String userName;
    private String passUser;

    public Account() {
    }

    public Account(String userName, String passUser) {
        this.userName = userName;
        this.passUser = passUser;
    }

    public Account(String adminName, String passAdmin, String userName, String passUser) {
        this.adminName = adminName;
        this.passAdmin = passAdmin;
        this.userName = userName;
        this.passUser = passUser;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
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
}
