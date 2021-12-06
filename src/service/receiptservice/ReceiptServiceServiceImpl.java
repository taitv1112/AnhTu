package service.receiptservice;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Receipt;

import java.io.IOException;
import java.util.List;

public class ReceiptServiceServiceImpl implements IReceiptService {
    public String PATH_RECEIPT = Path.PATH + "receipt.txt";
    ConfigReadAndWriteFile<Receipt> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Receipt> receiptList = configReadAndWriteFile.readFromFile(PATH_RECEIPT);

    @Override
    public List<Receipt> fillAll() throws IOException {
        configReadAndWriteFile.writeToFile(PATH_RECEIPT, receiptList);
        return receiptList;
    }

    @Override
    public void save(Receipt receipt) {
        receiptList.add(receipt);

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




}
