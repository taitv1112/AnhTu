package model;

import java.io.Serializable;

public class Receipt implements Serializable {
    private Room room;
    private int idReceipt; // id hoa don
    private String room_renter;// ng thue phong
    private String staff_name; // ten nhan vien
    private double bill;


    public Receipt() {
    }

    public Receipt(Room room, String room_renter, String staff_name, double start_time, double stop_time) {
        this.room = room;
        this.room_renter = room_renter;
        this.staff_name = staff_name;

    }

    public Receipt(Room room, int idReceipt, String room_renter, String staff_name, double start_time, double stop_time, double bill) {
        this.room = room;
        this.idReceipt = idReceipt;
        this.room_renter = room_renter;
        this.staff_name = staff_name;

        this.bill = bill;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getRoom_renter() {
        return room_renter;
    }

    public void setRoom_renter(String room_renter) {
        this.room_renter = room_renter;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }



    public String toString() {
        return "%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n"+
                idReceipt+ "," +
                room.getRoom_Name() + "," +
                room_renter+ "," +
                staff_name+ "," +
                bill;
    }


}
