package controller;

import model.Receipt;
import service.receiptservice.IReceiptService;
import service.receiptservice.ReceiptServiceServiceImpl;

import java.io.IOException;
import java.util.List;

public class ReceiptController {
    ReceiptServiceServiceImpl receiptServiceService = new ReceiptServiceServiceImpl();

    public List<Receipt> showListReceipt() throws IOException {
        return receiptServiceService.fillAll();
    }

    public void createReceipt(Receipt receipt) throws IOException {
        receiptServiceService.save(receipt);
    }
    public void editReceipt(int index,Receipt receipt) throws IOException {
        receiptServiceService.edit(index,receipt);
    }

    public int findIndexByIdReceipt(int idReceipt) throws IOException {
       return receiptServiceService.findIndexByidReceipt(idReceipt);
    }
    public Receipt detailReceipt(int id) {
        return receiptServiceService.findID(id);
    }

}
