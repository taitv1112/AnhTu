package service.accountService;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Account;

import java.io.IOException;
import java.util.List;

public class AccountService {
    public String PATH_ACCOUNT = Path.PATH + "account.txt";
    ConfigReadAndWriteFile<Account> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Account> accountList = configReadAndWriteFile.readFromFile(PATH_ACCOUNT);

    public void addAccount(Account account) throws IOException {
        for (Account ac: accountList) {
            if (ac.getUserName().equals(account.getPassUser())) {
                return;
            }
        }
        accountList.add(account);
        configReadAndWriteFile.writeToFile(PATH_ACCOUNT, accountList);
    }

    public List<Account> findAll() {
        return accountList;
    }

    public boolean login(Account account) {
        for (Account ac: accountList) {
            if (ac.getUserName().equals(account.getPassUser())) {
                return true;
            }
        }
        return false;
    }

    public boolean logAdmin(Account account) {
        if ("admin".equals(account.getUserName()) && "admin".equals(account.getPassUser())) {
            return true;
        }
        return false;
    }



}