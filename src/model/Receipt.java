package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Receipt implements Serializable {
    public static final String PENDING = "PENDING";
    public static final String ODER = "ODER";
    public static final String DONE = "DONE";
    private Date dateCheckIn;
    private  Date dateCheckOut;
    private long startTime;
    private long endTime;
    private Room room;
    private Guest guest;
    private Account account;
    private int idReceipt; // id hoa don
    private double bill;
    private String receipt_Status;

    public Date getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(Date dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public Date getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(Date dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getBill() {
        return (this.endTime-this.startTime)*room.getPrice()/60000;
    }

    public String getReceipt_Status() {
        return receipt_Status;
    }

    public void setReceipt_Status(String receipt_Status) {
        this.receipt_Status = receipt_Status;
    }

    public Receipt(int idReceipt, Room room, Account account, Guest guest) {
        this.idReceipt = idReceipt;
        this.dateCheckIn=new Date();
        this.startTime = System.currentTimeMillis();
        this.receipt_Status = Receipt.PENDING;
        this.room = room;
        this.guest = guest;
        this.account = account;
    }
    public Receipt(int idReceipt,Room room, Guest guest) {
        this.idReceipt = idReceipt;
        this.dateCheckIn=new Date();
        this.startTime = System.currentTimeMillis();
        this.receipt_Status = Receipt.PENDING;
        this.room = room;
        this.guest = guest;
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



    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return idReceipt+ "," + room.getRoom_Name()+ "," + account.getGuest()+
                ","+ account.getUserName()+
                ","+ dateCheckIn+ "," +
                dateCheckOut+ ","+ bill;
    }
}
