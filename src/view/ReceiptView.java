package view;

import controller.ReceiptController;
import controller.RoomController;
import io.Path;
import model.Receipt;
import model.Room;

import java.io.IOException;
import java.util.List;

public class ReceiptView {

    ReceiptController receiptController = new ReceiptController();
    RoomController roomController = new RoomController();
    List<Receipt> receiptList = receiptController.showListReceipt();
    List<Room> roomList = roomController.showListRoom();

    public ReceiptView() throws IOException {
    }

    public void viewShowListReceipt() throws IOException {
        System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n ,"+
                "ID hoa don",
                "Ten phong",
                "thue phong",
                " cho thue",
                "check in",
                "check out",
                "thanh toan");
        for (Receipt rs: receiptList) {
            System.out.format(rs.toString());
        }
        System.out.println("Nhap 'quit' de quay lai Menu");
        String back = Path.sc().next();
        if(back.equalsIgnoreCase("quit")){
            new Main();
        }
    }

    public void createReceipt() throws IOException {
        while (true) {
            int id;
            if (receiptList.size() == 0) {
                id = 1;
            }
            else {
                id = receiptList.get(receiptList.size() -1).getIdReceipt()+ 1;
            }
            System.out.println("Nhap ten phong");
            String room_name = Path.sc().nextLine();
            for (Room room: roomList) {
                if (room.getRoom_Name().equals(room_name)) {
                    System.out.println("Nhap ten nguoi thue phong");
                    String room_renter = Path.sc().nextLine();
                    System.out.println("Nhap ten nhan vien cho thue");
                    String staff_name = Path.sc().nextLine();
                    System.out.println("Ngay check in");
                    double start_time = Double.parseDouble(Path.sc().nextLine());
                    System.out.println("Ngay check out");
                    double stop_time = Double.parseDouble(Path.sc().nextLine());
                    double bill = (stop_time - start_time) * room.getPrice();
                    Receipt receipt = new Receipt(room, id,room_renter, staff_name, start_time, stop_time, bill);
                    receiptController.createReceipt(receipt);
                    receiptController.showListReceipt();
                    System.out.println("Enter any key to continue create - Enter QUIT to back MENU");
                    String back = Path.sc().next();
                    if(back.equalsIgnoreCase("quit")){
                        new Main();
                    }
                }
            }
        }
    }
}
