package view;

import controller.GuestController;
import controller.RoomController;
import io.Path;
import model.Guest;
import model.Receipt;
import model.Room;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/*
1. danh sach
2. tim kiem phong theo khoang gia.
3. dang ky phong



 */
public class GuestView {
    ReceiptView receiptView = new ReceiptView();
    RoomView roomView = new RoomView();
    GuestController guestController = new GuestController();


    public GuestView() throws IOException {
    }

    public Guest createGuest() throws IOException {
        System.out.println("Hay nhap ten cua quy khach");
        String guest_Name = Path.sc().nextLine();
        System.out.println("Hay nhap so dien thoai cua quy khach");
        int guest_PhoneNumber = Integer.parseInt(Path.sc().nextLine());
        System.out.println("Hay nhap dia chi email cua quy khach");
        String guest_Email = Path.sc().nextLine();
        Guest guest = new Guest(guest_Name,guest_PhoneNumber,guest_Email);
        return guest;
    }
    public void addGuestList() throws IOException {
        guestController.createGuest(createGuest());
    }
    public void viewMenuGuest() throws IOException {
        while (true) {
            System.out.println("1. Tim phong");
            System.out.println("2. Dang ky phong");
            System.out.println("3. Dich vu VIP ");
            System.out.println("4. back ");
            int choiceGuest = Integer.parseInt(Path.sc().nextLine());
            switch (choiceGuest) {
                case 1: roomView.viewMenuRoomGuest();break;
                case 2:receiptView.receiptUser();break;
                case 3:break;
                case 4:new Main();
            }
        }
    }
}
