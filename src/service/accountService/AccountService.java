package service.accountService;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Account;
import regex.Regex;

import java.io.IOException;
import java.util.List;

public class AccountService {
    Regex regex = new Regex();
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
    public int findIndexByUserNameAccount(String userName) {
        for (int i = 0; i < accountList.size(); i++) {
            if (userName.equals(accountList.get(i).getUserName())) {
                return i;
            }
        }
        return -1;
    }


    public List<Account> findAll() {
        return accountList;
    }

    public boolean login(Account account) {
        for (Account ac: accountList) {
            System.out.println(accountList);
            if (ac.getUserName().equals(account.getUserName()) && accessStaff()) {
                System.out.println("vao day ko");
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

    public boolean accessStaff() {
        accountList = configReadAndWriteFile.readFromFile(PATH_ACCOUNT);
        String name = regex.validateNotNull("Nhap ten vao day", "nhap bang chu cai nhe");
        int index = findIndexByUserNameAccount(name);
        if (index >=0 && accountList.get(index).isCheck()) {
            accountList.get(index).setCheck(true);
            return true;
        }
        return false;
    }

    public void showAcc () throws IOException {
        configReadAndWriteFile.writeToFile(PATH_ACCOUNT, accountList);
        for (Account ac: accountList) {
            System.out.println(ac.toString());
        }
    }


}