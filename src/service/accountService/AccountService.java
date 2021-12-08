package service.accountService;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Account;
import regex.Regex;

import java.io.IOException;
import java.util.List;

public class AccountService {
    Regex regex = new Regex();
    public String PATH_ACCOUNT;
    ConfigReadAndWriteFile<Account> configReadAndWriteFile;
    List<Account> accountList;
    public AccountService(){
       this.PATH_ACCOUNT = Path.PATH + "account.txt";
        this.configReadAndWriteFile = new ConfigReadAndWriteFile<>();
        accountList = configReadAndWriteFile.readFromFile(PATH_ACCOUNT);
    }
    public List<Account> findAll() {
        return accountList;
    }
    public void addAccount(Account account) throws IOException {
            accountList.add(account);
        configReadAndWriteFile.writeToFile(PATH_ACCOUNT, accountList);
    }
    public void edit(int index ,Account account) throws IOException {
        accountList.set(index,account);
        configReadAndWriteFile.writeToFile(PATH_ACCOUNT, accountList);
    }
    public void delete(int index) throws IOException {
        accountList.remove(index);
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


}