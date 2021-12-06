package controller;

import model.Receipt;
import service.receiptservice.IReceiptService;
import service.receiptservice.ReceiptServiceServiceImpl;

import java.io.IOException;
import java.util.List;

public class ReceiptController {
    IReceiptService iReceiptService = new ReceiptServiceServiceImpl();

    public List<Receipt> showListReceipt() throws IOException {
        return iReceiptService.fillAll();
    }

    public void createReceipt(Receipt receipt) {
        iReceiptService.save(receipt);
    }

    public Receipt detailReceipt(int id) {
        return iReceiptService.findID(id);
    }


}
