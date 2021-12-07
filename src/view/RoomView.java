package view;

import controller.RoomController;
import io.Path;
import model.Room;
import regex.Regex;
import service.roomservice.RoomServiceImpl;

import java.io.IOException;
import java.util.List;

/*




 */
public class RoomView {
    Regex regex = new Regex();
    RoomController roomController = new RoomController();
    RoomServiceImpl roomService = new RoomServiceImpl();
    List<Room> roomList = roomController.showListRoom();

    public RoomView() throws IOException {
    }

    public void viewShowListRoom() throws IOException {
        System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",
                "id", "Room_Name", "Rest_Room", "Bed_room", "Status", "Price");
        for (Room r:roomList) {
            String[] line = r.toString().split(",");
            System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",line[0],line[1],line[2],line[3],line[4],line[5]);

        }
    }

    public void createRoom() throws IOException {

            int id;
            if (roomList.size() == 0) {
                id = 1;
            } else {
                id = roomList.get(roomList.size() - 1).getId() + 1;
            }
            String room_Name = regex.validateNotNull("Nhap ten phong","Ten phong khong duoc bo ");
            int restroom =Integer.parseInt(regex.validate("Nhap so phong ve sinh", "Nhap so nguyen", Regex.NUMBER));
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
        if (roomService.IndexFindById(id) >= 0) {
            String room_Name = regex.validateNotNull("Nhap ten phong","Ten phong khong duoc bo ");
            int restroom = Integer.parseInt(regex.validate("Nhap so phong ve sinh", "Nhap so nguyen", Regex.NUMBER));
            int bedroom = Integer.parseInt(regex.validate("Nhap so phong ngu", "Nhap so nguyen", Regex.NUMBER));
            System.out.println("Nhap trang thai phong muon sua, 1.Dang trong, 2.Dang su dung, 3.Dang don dep");
            int choiceStatus = Integer.parseInt(Path.sc().nextLine());
            String status = null;
            double price = Double.parseDouble(regex.validate("Nhap gia phong", "Nhap so thuc khong am", Regex.NUMBER));
            Room room = new Room(id, room_Name, restroom, bedroom, status, price);
            switch (choiceStatus) {
                case 1: {
                    room.setStatus(room.getROOM_EMPTY());
                    break;
                }
                case 2: {
                    room.setStatus(room.getROOM_USE());
                    break;
                }
                case 3: {
                    room.setStatus(room.getROOM_CLEANING());
                    break;
                }
            }
            roomController.editRoom(id, room);
            roomController.showListRoom();
        } else {
            System.out.println("Khong tim Id phong muon sua");
        }

    }
}