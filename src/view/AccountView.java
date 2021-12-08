package view;

import controller.AccountController;
import controller.GuestController;
import controller.RoomController;
import io.Path;
import model.Account;

import java.io.IOException;

public class AccountView {
    GuestController guestController = new GuestController();
    AccountController accountController = new AccountController();
    ReceiptView receiptView = new ReceiptView();
    RoomView roomView = new RoomView();


    public AccountView() throws IOException {
    }



    public String CheckLogin() throws IOException {
        while (true) {
            System.out.println("Nhap UserName");
            String userName = Path.sc().nextLine();
            System.out.println("Nhap Password");
            String password = Path.sc().nextLine();
            boolean isAvailableAccountUsser = checkUser(userName,password);
            String isAvailableAccountManager = checkAdmin_Staff(userName,password);
            if(isAvailableAccountUsser){
                return Account.USER;
            }else
            if(isAvailableAccountManager.equals(Account.ADMIN)){
                return Account.ADMIN;
            }else if(isAvailableAccountManager.equals(Account.STAFF)){
                return Account.STAFF;
            }else {
                    System.out.println("Wrong Pass- Enter any key to Continue or Enter Q to back menu");
                    String option = Path.sc().nextLine();
                    if (option.equals("Q")) {
                        return "Wrong Pass";
                }

            }
        }
    }
//kiem tra tren cung 1 list account, va check theo roll;
    public boolean checkUser(String userName, String password) throws IOException {
       int index = guestController.findIndexByUserNameGuest(userName);
        if (index > -1 ) {
            return password.equals(guestController.showListGuest().get(index).getGuest_Email());
        }else {
            return false;
        }

    }

    public String checkAdmin_Staff(String userName, String password) {
        int index = accountController.findIndexByUserNameAccount(userName);
        if(index >-1){
        Account account = accountController.showListAcc().get(index);
        if (account.getRole().equals(Account.ADMIN) && password.equals(account.getPassUser())) {
            return Account.ADMIN;
        }
        if (account.getRole().equals(Account.STAFF) && password.equals(account.getPassUser())) {
            return Account.STAFF;
        }
            return "Wrong Pass";
    }return "Wrong Pass";
    }


    public Account createAccount(String type) {
        System.out.println("Nhap UserName");
        String userName = Path.sc().nextLine();
        System.out.println("Nhap Password");
        String password = Path.sc().nextLine();
        if (type.equals(Account.ADMIN)) {
            return new Account(userName, password);
        }
        System.out.println("Nhap name");
        String name = Path.sc().nextLine();
        System.out.println("Nhap phone");
        String phone = Path.sc().nextLine();
        System.out.println("Nhap address");
        String address = Path.sc().nextLine();
        return new Account(userName, password, name, phone, address);
    }

    public void addAccount(String type) throws IOException {
        if (type.equals(Account.ADMIN)) {
            System.out.println("Enter Secert Code");
            String secretCode = Path.sc().nextLine();
            if (secretCode.equals("NgocTrinh")) {
                Account account = createAccount(Account.ADMIN);
                accountController.createAcc(account);
            }
        } else {
            Account account = createAccount(Account.STAFF);
            accountController.createAcc(account);
        }
    }

    public void showCvAndProcessing() {
        int count = 0;
        for (Account a : accountController.showListAcc()) {
            if (a.getRole().equals(Account.USER)) {
                System.out.println(a);
                count++;
            }
        }
        if (count != 0) {
            while (true) {
                String userName = Path.sc().nextLine();
                int index = accountController.findIndexByUserNameAccount(userName);
                if (index > -1) {
                    String option = Path.sc().nextLine();
                    if (option.equals("Accept")) {
                        accountController.showListAcc().get(index).setRole(Account.STAFF);
                    } else {
                        return;
                    }
                } else {
                    System.out.println("User Name is not exits- Enter any key to Continue or Enter Q to back menu");
                    String option = Path.sc().nextLine();
                    if (option.equals("Q")) {
                        return;
                    }
                }
            }
        }
    }
    public void viewMenuAmin() throws IOException {
        while(true){
            System.out.println("QUan ly khach san");
            System.out.println("1. Quan ly phong");
            System.out.println("2. Quan ly hoa don");
            System.out.println("3. Quan ly nhan vien");
            System.out.println("4. back to login");
            int choiceMenu = Integer.parseInt(Path.sc().nextLine());
            switch (choiceMenu) {
                case 1:roomView.viewRoomManager();break;
                case 2:receiptView.viewReceiptManager();break;
                case 3:showCvAndProcessing();break;
                case 4:new Main();
            }
        }

    }
    public void viewMenuStaff() throws IOException {
        while(true){
            System.out.println("QUan ly khach san");
            System.out.println("1. Quan ly phong");
            System.out.println("2. Quan ly hoa don");
            System.out.println("3. back to login");
            int choiceMenu = Integer.parseInt(Path.sc().nextLine());
            switch (choiceMenu) {
                case 1:roomView.viewRoomManager();break;
                case 2:receiptView.viewwReceiptStaff();break;

                case 3:new Main();
            }
        }

    }
    public void viewMenuAll() throws IOException {
        AccountView accountView = new AccountView();
        GuestView guestView = new GuestView();
        while (true) {
            System.out.println("---Khach san 5* ---");
            System.out.println("1. Dang nhap");
            System.out.println("2. Dang ky nhan vien ");
            System.out.println("3. Khach hang register");
            System.out.println("4. admin register");
            System.out.println("5. back");
            int choiceLogin = Path.sc().nextInt();
            switch (choiceLogin) {
                case 1: {
                    String check = CheckLogin();
                    if(check.equals(Account.ADMIN)){
                        accountView.viewMenuAmin();
                    }else if(check.equals(Account.STAFF)){
                        accountView.viewMenuStaff();
                    }else if(check.equals(Account.USER)) {
                        guestView.viewMenuGuest();
                    }else {
                        break;
                    }
                }
                case 2: {
                    accountView.addAccount(Account.STAFF);
                    break;
                }
                case 3: guestView.addGuestList();break;
                case 4:accountView.addAccount(Account.ADMIN);break;
                case 5:
                    return;
            }


        }
    }

}
