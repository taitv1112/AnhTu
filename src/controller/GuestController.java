package controller;

import model.Guest;
import model.Room;
import service.guestService.GuestService;

import java.io.IOException;
import java.util.List;

public class GuestController {

    GuestService guestService = new GuestService();

    public List<Guest> showListGuest() throws IOException {
        return guestService.fillAll();
    }

    public void createGuest(Guest guest) throws IOException {
        guestService.save(guest);
    }
    public int findIndexByUserNameGuest(String guestName) {
        return guestService.findIndexByUserName(guestName);
    }

}
