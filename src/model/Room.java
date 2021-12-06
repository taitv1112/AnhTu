package model;

import java.io.Serializable;

public class Room implements Serializable {
    private int id;
    private String room_Name;
    private int restroom;
    private int bedroom;
    private final String ROOM_EMPTY = "ROOM EMPTY";
    private final String ROOM_USE = "ROOM USER";
    private final String ROOM_CLEANING = "ROOM CLEANING";
    private String status;
    private long check_in_time;
    private long check_out_time;
    private double price;

    public Room() {
    }


    public Room(int id, String room_Name, int restroom, int bedroom, String status, double price) {
        this.id = id;
        this.room_Name = room_Name;
        this.restroom = restroom;
        this.bedroom = bedroom;
        this.status = status;
        this.price = price;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_Name() {
        return room_Name;
    }

    public void setRoom_Name(String room_Name) {
        this.room_Name = room_Name;
    }

    public int getRestroom() {
        return restroom;
    }

    public void setRestroom(int restroom) {
        this.restroom = restroom;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getROOM_EMPTY() {
        return ROOM_EMPTY;
    }

    public String getROOM_USE() {
        return ROOM_USE;
    }

    public String getROOM_CLEANING() {
        return ROOM_CLEANING;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                id + ","+ room_Name+ ","+ restroom+ ","+ bedroom+ "," + status+ "," + price +'\n';
//                "Room{" +
//                "id=" + id +
//                ", room_Name='" + room_Name + '\'' +
//                ", restroom=" + restroom +
//                ", bedroom=" + bedroom +
//                ", status='" + status + '\'' +
//                ", price=" + price +
//                '}'+ '\n';
    }
}
