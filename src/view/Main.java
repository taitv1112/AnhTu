package view;

import controller.RoomController;
import io.Path;
import model.Account;
import service.accountService.AccountService;

import java.io.IOException;
import java.util.List;

/*
---Khach san...---
1. Dang nhap
2. Dang ky
3. Khach hang
3.1 Hien thi thong tin phong
3.2

 */
public class Main {
    AccountView accountView = new AccountView();
    ReceiptView receiptView = new ReceiptView();
    AccountService accountService = new AccountService();
    RoomController roomController = new RoomController();
    GuestView guestView = new GuestView();


    public Main() throws IOException {
        while (true) {
            int choiceLogin = accountView.menuLogin();
            switch (choiceLogin) {
                case 1: {
                    Account account = accountView.createAccount();
                    if (accountService.logAdmin(account)) {
                        System.out.println("QUan ly khach san");
                        System.out.println("1. Quan ly phong");
                        System.out.println("2. Quan ly hoa don");
                        System.out.println("3. Quan ly dich vu");
                        System.out.println("4. Quan ly nhan vien");
                        int choiceMenu = Integer.parseInt(Path.sc().nextLine());
                        switch (choiceMenu) {
                            case 1: {
                                roomManager();
                                break;
                            }
                            case 2: {
                                receiptManager();
                                break;
                            }
                            case 4: {
                                AccessManager();
                                break;
                            }
                            //case3: quan ly dich vu
                        }
                    }
                    if (accountService.login(account)) {
                        System.out.println("Danh sach phong");
                        roomManager();

                    }
                    break;
                }
                case 2: {
                    accountView.addAccount();
                    break;
                }
                case 3: {
                    guestManager();
                    break;
                }
            }


        }



    }
    public void AccessManager() throws IOException {
        AccountService accountService = new AccountService();
        accountService.showAcc();
        accountService.accessStaff();

    }

    public void roomManager() throws IOException {

        RoomView roomView = new RoomView();
        while (true) {
            System.out.println("1. Danh sach phong");
            System.out.println("2. Tao phong moi");
            System.out.println("3. Sua phong");
            System.out.println("4. Xoa phong");
            System.out.println("5. Xac nhan dat phong");
            int choiceRoomM = Integer.parseInt(Path.sc().nextLine());
            switch (choiceRoomM) {
                case 1: {
                    roomView.viewShowListRoom();
                    break;
                }
                case 2: {
                    roomView.createRoom();
                    break;
                }
                case 3: {
                    roomView.viewEditRoom();
                    break;
                }
                case 4: {
                    roomView.viewDeleteRoom();
                    break;
                }
                default:{
                    new Main();
                }
            }
        }
    }

    public void receiptManager() throws IOException {
        ReceiptView receiptView = new ReceiptView();
        System.out.println("1. Danh sach hoa don");
        System.out.println("2. Tao hoa don");
        System.out.println("3. Sua hoa don");
        System.out.println("4. Xoa hoa don");
        int choiceReceiptM = Integer.parseInt(Path.sc().nextLine());
        switch (choiceReceiptM) {
            case 1: {
                receiptView.viewShowListReceipt();
                break;
            }
            case 2: {
                receiptView.createReceiptCheckIn(Account.STAFF);
                break;
            }
        }

    }

    public void guestManager() throws IOException {
        AccountView accountView = new AccountView();
        System.out.println("1. Danh sach phong dang trong");
        System.out.println("2. Tim kiem phong theo gia");
        System.out.println("3. Dich vu VIP ");
        System.out.println("4. Dang ky phong");
        int choiceGuest = Integer.parseInt(Path.sc().nextLine());
        switch (choiceGuest) {
            case 1: {
                guestView.viewShowListRoomInGuest();
                guestManager();
                break;
            }
            case 2: {
                System.out.println("Nhap gia thap nhat muon tim");
                double min = Double.parseDouble(Path.sc().nextLine());
                System.out.println("Nhap gia cao nhat muon tim");
                double max = Double.parseDouble(Path.sc().nextLine());
                System.out.println("            ----Danh sach phong tim kiem----      ");
                System.out.format("%-5s %-10s %-10s %-10s %-15s %-5s \n",
               "id", "Room_Name", "Rest_Room", "Bed_room", "Status", "Price");
                guestView.roomSearchByPrice(min, max);
                guestManager();
                break;
            }
            case 4: {
                receiptView.createReceiptCheckIn("Guest");
                guestManager();
                break;
            }
            case 5:receiptView.showReceipt();break;
            default: {
                new Main();
            }
        }
    }
    public static void main(String[] args) throws IOException {
	new Main();
    }
}
