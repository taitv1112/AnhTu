package service.receiptservice;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Receipt;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.util.List;

public class ReceiptServiceServiceImpl implements IReceiptService {
    public String PATH_RECEIPT = Path.PATH + "receipt.txt";
    ConfigReadAndWriteFile<Receipt> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Receipt> receiptList = configReadAndWriteFile.readFromFile(PATH_RECEIPT);

    @Override
    public List<Receipt> fillAll() throws IOException {
        return receiptList;
    }

    @Override
    public void save(Receipt receipt) throws IOException {
        receiptList.add(receipt);
        configReadAndWriteFile.writeToFile(PATH_RECEIPT, receiptList);
    }

    @Override
    public Receipt findID(int id) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (receiptList.get(i).getIdReceipt() == id) {
                return receiptList.get(i);
            }
        }
        return null;
    }
    public int findIndexByidReceipt(int id) {
        for (int i = 0; i < receiptList.size(); i++) {
            if (id==receiptList.get(i).getIdReceipt()) {
                return i;
            }
        }
        return -1;
    }

    public void edit( int index, Receipt receipt) throws IOException {
        receiptList.set(index,receipt);
        configReadAndWriteFile.writeToFile(PATH_RECEIPT, receiptList);
    }



}
