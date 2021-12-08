package view;

import controller.RoomController;
import io.Path;
import model.Room;
import regex.Regex;

import java.io.IOException;

/*




 */
public class RoomView {
    Regex regex = new Regex();
    RoomController roomController = new RoomController();

    public RoomView() throws IOException {
    }

    public void viewShowListRoom() throws IOException {
        System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",
                "id", "Room_Name", "Rest_Room", "Bed_room", "Status", "Price");
        for (Room r : roomController.showListRoom()) {
            String[] line = r.toString().split(",");
            System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);

        }
    }

    public void createRoom() throws IOException {

        int id;
        if (roomController.showListRoom().size() == 0) {
            id = 1;
        } else {
            id = roomController.showListRoom().get(roomController.showListRoom().size() - 1).getId() + 1;
        }
        String room_Name = regex.validateNotNull("Nhap ten phong", "Ten phong khong duoc bo ");
        int restroom = Integer.parseInt(regex.validate("Nhap so phong ve sinh", "Nhap so nguyen", Regex.NUMBER));
        int bedroom = Integer.parseInt(regex.validate("Nhap so phong ngu", "Nhap so nguyen", Regex.NUMBER));
        double price = Double.parseDouble(regex.validate("Nhap gia phong", "Nhap so thuc khong am", Regex.NUMBER));
        Room room = new Room(id, room_Name, restroom, bedroom, price);
        room.setStatus(room.getROOM_EMPTY());
        roomController.createRoom(room);
        roomController.showListRoom();
    }

    public void viewDeleteRoom() throws IOException {
        int id = Integer.parseInt(regex.validate("nhap ID muon xoa", "Nhap so nguyen", Regex.NUMBER));
        if (roomController.deleteRoom(id)) {
            roomController.showListRoom();
            System.out.println("Da xoa thanh cong");
        } else {
            System.out.println("Khong tim thay ID phong");

        }
    }

    public void viewEditRoom() throws IOException {
        int id = Integer.parseInt(regex.validate("Nhap ID phong muon sua", "Nhap so nguyen", Regex.NUMBER));
        if (roomController.indexFindByRoomID(id) >= 0) {
            String room_Name = regex.validateNotNull("Nhap ten phong", "Ten phong khong duoc bo ");
            int restroom = Integer.parseInt(regex.validate("Nhap so phong ve sinh", "Nhap so nguyen", Regex.NUMBER));
            int bedroom = Integer.parseInt(regex.validate("Nhap so phong ngu", "Nhap so nguyen", Regex.NUMBER));
            System.out.println("Nhap trang thai phong muon sua, 1.Dang trong, 2.Dang su dung, 3.Dang don dep");
            int choiceStatus = Integer.parseInt(Path.sc().nextLine());
            String status = null;
            double price = Double.parseDouble(regex.validate("Nhap gia phong", "Nhap so thuc khong am", Regex.NUMBER));
            Room room = new Room(id, room_Name, restroom, bedroom, status, price);
            switch (choiceStatus) {
                case 1: {
                    room.setStatus(Room.ROOM_EMPTY);
                    break;
                }
                case 2: {
                    room.setStatus(Room.ROOM_USE);
                    break;
                }
                case 3: {
                    room.setStatus(Room.ROOM_CLEANING);
                    break;
                }
            }
            roomController.editRoom(id, room);
            roomController.showListRoom();
        } else {
            System.out.println("Khong tim Id phong muon sua");
        }
    }

    public void viewShowListRoomEmpty() throws IOException {
        System.out.println("            ----Danh sach phong dang trong----      ");
        System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",
                "id", "Room_Name", "Rest_Room", "Bed_room", "Status", "Price");
        for (Room r : roomController.showListRoom()) {
            if (r.getStatus().equals(Room.ROOM_EMPTY)) {
                String[] line = r.toString().split(",");
                System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);
            }
        }
    }

    public void viewRoomSearchByPrice() throws IOException {
        System.out.println("Enter Price start");
        int priceStart = Path.sc().nextInt();
        System.out.println("Enter Price end");
        int priceEnd = Path.sc().nextInt();
        if (priceStart > priceEnd) {
            int count = 0;
            for (Room r : roomController.showListRoom()) {
                if (r.getPrice() >= priceEnd && r.getPrice() < priceStart) {
                    String[] line = r.toString().split(",");
                    System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not room in Range Price");


            }
        } else {
            int count = 0;
            for (Room r : roomController.showListRoom()) {
                if (r.getPrice() >= priceStart && r.getPrice() < priceEnd) {
                    String[] line = r.toString().split(",");
                    System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n", line[0], line[1], line[2], line[3], line[4], line[5]);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not room in Range Price");
            }
        }
    }
        public void viewRoomManager() throws IOException {

            while (true) {
                System.out.println("1. Danh sach phong");
                System.out.println("2. Tao phong moi");
                System.out.println("3. Sua phong");
                System.out.println("4. Xoa phong");
                System.out.println("5. tim phong theo khoang gia");
                System.out.println("6. hien thi phong trong");
                System.out.println("7. back");

                int choiceRoomM = Integer.parseInt(Path.sc().nextLine());
                switch (choiceRoomM) {
                    case 1: {
                        viewShowListRoom();
                        break;
                    }
                    case 2: {
                        createRoom();
                        break;
                    }
                    case 3: {
                        viewEditRoom();
                        break;
                    }
                    case 4: {
                        viewDeleteRoom();
                        break;
                    }
                    case 5:
                        viewRoomSearchByPrice();
                        break;
                    case 6: viewShowListRoomEmpty();break;
                    case 7: return;
                }
            }
        }
    public void viewMenuRoomGuest() throws IOException {

        while (true) {
            System.out.println("1. tim phong theo khoang gia");
            System.out.println("2. hien thi phong trong");
            System.out.println("3. back");

            int choiceRoomM = Integer.parseInt(Path.sc().nextLine());
            switch (choiceRoomM) {
                case 1:
                    viewRoomSearchByPrice();
                    break;
                case 2: viewShowListRoomEmpty();break;
                case 3: return;
            }
        }
    }
    }