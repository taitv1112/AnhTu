package controller;

import model.Account;
import service.accountService.AccountService;

import java.io.IOException;
import java.util.List;

public class AccountController {
    AccountService accountService = new AccountService();
    public List<Account> showListAcc() {
        return accountService.findAll();
    }

    public void createAcc(Account account) throws IOException {
        accountService.addAccount(account);
    }
    public int findIndexByUserNameAccount(String userName) {
       return accountService.findIndexByUserNameAccount(userName);
    }


}
