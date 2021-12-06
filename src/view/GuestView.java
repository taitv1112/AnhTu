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
    RoomController roomController = new RoomController();
    GuestController guestController = new GuestController();
    List<Room> roomList = roomController.showListRoom();
    List<Guest> guestList = guestController.showListGuest();
    public GuestView() throws IOException {
    }

    public void viewShowListRoomInGuest() throws IOException {
        System.out.println("            ----Danh sach phong dang trong----      ");
        System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",
                "id", "Room_Name", "Rest_Room", "Bed_room", "Status", "Price");
        for (Room r : roomList) {
            if (r.getStatus().equals("ROOM EMPTY")) {
                String[] line = r.toString().split(",");
                System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);
            }
        }
    }

    public void roomSearchByPrice(double min, double max) {
        for (Room r : roomList) {
            Room room = guestController.searchValuePrice(min, max, r);
            if (room != null) {
                String[] line = room.toString().split(",");
                System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);
            }
        }

    }

    public void createGuest() {
        Room room = new Room();
        Receipt receipt = new Receipt();
        Date date = new Date();

            System.out.println("Hay nhap ten cua quy khach");
            String guest_Name = Path.sc().nextLine();
            System.out.println("Hay nhap so dien thoai cua quy khach");
            int guest_PhoneNumber = Integer.parseInt(Path.sc().nextLine());
            System.out.println("Hay nhap dia chi email cua quy khach");
            String guest_Email = Path.sc().nextLine();
            System.out.println("Nhap ten phong muon thue");
            String room_Name = Path.sc().nextLine();
            for (int i = 0; i < roomList.size(); i++) {
                if (roomList.get(i).getRoom_Name().equals(room_Name) && roomList.get(i).getStatus().equals("ROOM EMPTY")) {
                    Guest guest = new Guest(room, guest_Name, guest_PhoneNumber, guest_Email);
                    guestController.createGuest(guest);

                }
            }
        System.out.println("Dang ky phong thanh cong");

    }
}
