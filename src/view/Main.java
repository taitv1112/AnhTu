package view;

import controller.RoomController;
import io.Path;
import model.Account;
import service.accountService.AccountService;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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


    public static void main(String[] args) throws IOException {
        AccountView accountView = new AccountView();
        accountView.viewMenuAll();
    }




}
