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
    private String name;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String role;
    public static final String STAFF = "STAFF";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private boolean check;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account() {
    }

    public Account(String userName, String passUser, String name, String phone, String address) {
        this.userName = userName;
        this.passUser = passUser;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.role = Account.USER;
    }

    public Account(String userName, String passUser) {
        this.userName = userName;
        this.passUser = passUser;
        this.role = Account.ADMIN;

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

                ", role='" + role + '\'' +
                ", check=" + check +
                '}';
    }
}
