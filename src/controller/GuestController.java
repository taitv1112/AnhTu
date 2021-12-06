package controller;

import model.Guest;
import model.Room;
import service.guestService.GuestService;

import java.io.IOException;
import java.util.List;

public class GuestController {

    GuestService guestService = new GuestService();

    public Room searchValuePrice(double min, double max, Room room) {
       return guestService.searchPrice(min, max, room);
    }

    public List<Guest> showListGuest() throws IOException {
        return guestService.fillAll();
    }

    public void createGuest(Guest guest) {
        guestService.save(guest);
    }
}
