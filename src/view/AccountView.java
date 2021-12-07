package view;

import config.ConfigReadAndWriteFile;
import controller.AccountController;
import controller.RoomController;
import io.Path;
import model.Account;
import model.Room;

import java.io.IOException;
import java.util.List;

public class AccountView {
    public String PATH_ACC = Path.PATH+ "account.txt";
    RoomController roomController = new RoomController();
    AccountController accountController = new AccountController();
    List<Room> roomList = roomController.showListRoom();
    List<Account> accountList = accountController.showListAcc();
    ConfigReadAndWriteFile<Account> accountConfigReadAndWriteFile = new ConfigReadAndWriteFile<>();
    public AccountView() throws IOException {
    }


    public int menuLogin () {
        System.out.println("---Khach san 5* ---");
        System.out.println("1. Dang nhap");
        System.out.println("2. Dang ky");
        System.out.println("3. Khach hang");
        return Integer.parseInt(Path.sc().nextLine());
    }

    public Account createAccount() {
        System.out.println("Nhap UserName");
        String userName = Path.sc().nextLine();
        System.out.println("Nhap Password");
        String password = Path.sc().nextLine();
        return new Account(userName, password);

    }
    public void addAccount() {
        accountList = accountConfigReadAndWriteFile.readFromFile(PATH_ACC);
        Account account = createAccount();
        accountList.add(account);
        accountController.showListAcc();
    }





}
