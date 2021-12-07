package model;

import java.io.Serializable;

public class Guest implements Serializable {
    private int idGuest;
    private String guest_Name;
    private int guest_PhoneNumber;
    private String guest_Email;
    private static int idNumber =1 ;


    public Guest( String guest_Name, int guest_PhoneNumber, String guest_Email) {
        int idGuest =idNumber++;
        this.guest_Name = guest_Name;
        this.guest_PhoneNumber = guest_PhoneNumber;
        this.guest_Email = guest_Email;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public String getGuest_Name() {
        return guest_Name;
    }

    public void setGuest_Name(String guest_Name) {
        this.guest_Name = guest_Name;
    }

    public int getGuest_PhoneNumber() {
        return guest_PhoneNumber;
    }

    public void setGuest_PhoneNumber(int guest_PhoneNumber) {
        this.guest_PhoneNumber = guest_PhoneNumber;
    }

    public String getGuest_Email() {
        return guest_Email;
    }

    public void setGuest_Email(String guest_Email) {
        this.guest_Email = guest_Email;
    }


    @Override
    public String toString() {
        return "Guest{" +
                ", guest_Name='" + guest_Name + '\'' +
                ", guest_PhoneNumber='" + guest_PhoneNumber + '\'' +
                ", guest_Email='" + guest_Email + '\'' +
                '}';
    }
}
