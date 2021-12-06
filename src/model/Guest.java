package model;

public class Guest {
    private Room room;
    private String guest_Name;
    private int guest_PhoneNumber;
    private String guest_Email;

    public Guest() {
    }

    public Guest(Room room, String guest_Name, int guest_PhoneNumber, String guest_Email) {
        this.room = room;
        this.guest_Name = guest_Name;
        this.guest_PhoneNumber = guest_PhoneNumber;
        this.guest_Email = guest_Email;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
                "room=" + room +
                ", guest_Name='" + guest_Name + '\'' +
                ", guest_PhoneNumber='" + guest_PhoneNumber + '\'' +
                ", guest_Email='" + guest_Email + '\'' +
                '}';
    }
}
