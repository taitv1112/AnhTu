package view;

import controller.RoomController;
import io.Path;
import model.Room;
import service.roomservice.RoomServiceImpl;

import java.io.IOException;
import java.util.List;

/*




 */
public class RoomView {
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
//        System.out.println(roomController.showListRoom());
        System.out.println("Enter any key to continue create - Enter QUIT to back MENU");
        String back = Path.sc().next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void createRoom() throws IOException {
        while (true) {
            int id;
            if (roomList.size() == 0) {
                id = 1;
            } else {
                id = roomList.get(roomList.size() - 1).getId() + 1;
            }
            System.out.println("Nhap ten phong");
            String room_Name = Path.sc().nextLine();
            System.out.println("Nhap so phong ve sinh");
            int restroom = Integer.parseInt(Path.sc().nextLine());
            System.out.println("Nhap so phong ngu");
            int bedroom = Integer.parseInt(Path.sc().nextLine());
            String status = null;
            System.out.println("Nhap gia phong");
            double price = Double.parseDouble(Path.sc().nextLine());
            Room room = new Room(id, room_Name, restroom, bedroom, status, price);
            room.setStatus(room.getROOM_EMPTY());
            roomController.createRoom(room);
            roomController.showListRoom();
            System.out.println("Enter any key to continue create - Enter QUIT to back MENU");
            String back = Path.sc().next();
            if (back.equalsIgnoreCase("quit")) {
                new Main();
            }

        }
    }

    public void viewDeleteRoom() throws IOException {
        System.out.println("Nhap id phong muon xoa");
        int id = Integer.parseInt(Path.sc().nextLine());
        if (roomController.deleteRoom(id)) {
            roomController.showListRoom();
            System.out.println("Da xoa thanh cong");
        } else {
            System.out.println("Khong tim thay ID phong");

        }
        System.out.println("Enter any key to continue delete - Enter QUIT to back MENU");
        String back = Path.sc().next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void viewEditRoom() throws IOException {
        System.out.println("Nhap id phong muon sua");
        int id = Integer.parseInt(Path.sc().nextLine());
        if (roomService.IndexFindById(id) >= 0) {
            System.out.println("Nhap ten phong muon sua");
            String room_Name = Path.sc().nextLine();
            System.out.println("Nhap so phong ve sinh muon sua");
            int restroom = Integer.parseInt(Path.sc().nextLine());
            System.out.println("Nhap so phong ngu muon sua");
            int bedroom = Integer.parseInt(Path.sc().nextLine());
            System.out.println("Nhap trang thai phong muon sua, 1.Dang trong, 2.Dang su dung, 3.Dang don dep");
            int choiceStatus = Integer.parseInt(Path.sc().nextLine());
            String status = null;
            System.out.println("Nhap gia phong");
            double price = Double.parseDouble(Path.sc().nextLine());
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

        System.out.println("Enter any key to continue edit - Enter QUIT to back MENU");
        String back = Path.sc().next();
        if (back.equalsIgnoreCase("quit")) {
            new Main();
        }
    }
}