package view;

import controller.AccountController;
import controller.GuestController;
import controller.ReceiptController;
import controller.RoomController;
import io.Path;
import model.Account;
import model.Guest;
import model.Receipt;
import model.Room;
import regex.Regex;

import java.io.IOException;
import java.util.List;

public class ReceiptView {
    Regex regex = new Regex();
    GuestView guestView = new GuestView();
    AccountController accountController = new AccountController();
    GuestController guestController = new GuestController();
    ReceiptController receiptController = new ReceiptController();
    RoomController roomController = new RoomController();
    List<Receipt> receiptList = receiptController.showListReceipt();
    List<Room> roomList = roomController.showListRoom();

    public ReceiptView() throws IOException {
    }

    public void viewShowListReceipt() throws IOException {
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n ," +
                        "ID hoa don",
                "Room_Name",
                "Guest_Name",
                "Staff_Name",
                "Check in",
                "Check out",
                "Bill");
        for (Receipt rs: receiptList) {
            String[] line = rs.toString().split(",");
            System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",line[0],line[1],line[2],line[3],line[4],line[5], line[6]);
        }
        System.out.println("Nhap 'quit' de quay lai Menu");
        String back = Path.sc().next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void createReceiptCheckIn(String type) throws IOException {
        while (true) {
            int id;
            if (receiptList.size() == 0) {
                id = 1;
            } else {
                id = receiptList.get(receiptList.size() - 1).getIdReceipt() + 1;
            }
            Room room = checkRoom();
            if(type.equals(Account.STAFF)){
                Account accountStaff = accountStaff();
                Guest guest =getGuest();
                Receipt receipt = new Receipt(id,room,guest);
                receiptController.createReceipt(receipt);
            }else {
                Guest guest =getGuest();
                Receipt receipt = new Receipt(id,room,guest);
                receiptController.createReceipt(receipt);
            }

        }
    }

    public void createReceiptCheckOut(String type) throws IOException {
        while (true) {
            int idReceipt = Integer.parseInt(regex.validate("Nhap id hoa don", "nhap so nguyen", Regex.NUMBER));
            int index = receiptController.findIndexByIdReceipt(idReceipt);
            if(index>-1){
                // hien thi hoa
                showReceipt();
                System.out.println("Id hop le ban co muon hoan thanh hoa don nay ko ?. Please enter option:  yes or no  ");
                String option = regex.validate("Id hop le ban co muon hoan thanh hoa don nay ko ? Chon: Co hoac Khong", "Nhap Co hoac Khong", Regex.NAME);
                if(option.equalsIgnoreCase("co")){
                    Receipt receipt = receiptController.showListReceipt().get(index);
                    receipt.getRoom().setStatus(Room.ROOM_CLEANING);
                    receipt.setReceipt_Status(Receipt.DONE);
                    receipt.setEndTime(System.currentTimeMillis());
                    receiptController.editReceipt(index,receipt);
                    //hien thi thong tin hoa don sau khi thanh toan
                }else {
                    break;
                }
            }
        }
    }

    private Guest getGuest() throws IOException {

        System.out.println("Thong tin nguoi su dung . Neu da co tai khoan an 1 . chua thi an an key");
        String option = Path.sc().nextLine();
        if(option.equals("1")){
            Guest guest = accountUser();
            return guest;
        }else {
            Guest guest = guestView.createGuest();
            guestController.createGuest(guest);
            return guest;
        }
    }

    private Room checkRoom() throws IOException {
        while (true) {
            System.out.println("Nhap ten phong");
            String room_name = Path.sc().nextLine();
            int index = roomController.indexFindByRoomName(room_name);
            if (roomController.showListRoom().get(index).getStatus().equals(Room.ROOM_EMPTY)) {
                if (index > -1) {
                    roomController.showListRoom().get(index).setStatus(Room.ROOM_USE);
                    return roomController.showListRoom().get(index);
                } else {
                    System.out.println("Phong khong ton tai ");
                }
            } else {
                System.out.println("Phong chua san sang ");
            }
        }
    }

    private Account accountStaff() {
        while (true) {
            System.out.println("Nhap ten nhan vien cho thue");
            String staff_name = Path.sc().nextLine();
            int index = accountController.findIndexByUserNameAccount(staff_name);
            if (index > -1 && accountController.showListAcc().get(index).getRole().equals(Account.STAFF)) {
                return accountController.showListAcc().get(index);
            } else {
                System.out.println("ten nhan vien khong ton tai");
            }
        }
    }
    public void showReceipt(){
        System.out.format("%-5s %-10s %-10s %-10s %-5s  \n",
                "idReceipt", "Room_Name", "Guest_Name", "Staff_Name", "Check In Day", "Check Out Day", "Bill");
        for (Receipt rs: receiptList) {
            String[] line = rs.toString().split(",");
            System.out.format("%-5s %-10s %-10s %-10s %-5s \n",line[0],line[1],line[2],line[3],line[4]);
        }
    }
    private Guest accountUser() throws IOException {
        while (true) {
            System.out.println("Nhap ten khach cho thue");
            String guestName = Path.sc().nextLine();
            int index = guestController.findIndexByUserName(guestName);
            if (index > -1 ) {
                return guestController.showListGuest().get(index);
            } else {
                System.out.println("ten khach ton tai");
            }
        }
    }
}
