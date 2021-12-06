package service.guestService;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Guest;
import model.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuestService {
    public String PATH_ROOM = Path.PATH + "room.txt";
    public String PATH_GUEST = Path.PATH + "guest.txt";
    ConfigReadAndWriteFile<Room> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Room> roomList = configReadAndWriteFile.readFromFile(PATH_ROOM);

    ConfigReadAndWriteFile<Guest> configReadAndWriteFileGuest = new ConfigReadAndWriteFile<Guest>();
    List<Guest> guestList = configReadAndWriteFileGuest.readFromFile(PATH_GUEST);

    public Room searchPrice(double min, double max, Room room) {
            if (room.getPrice() >= min && room.getPrice() <= max && room.getStatus().equals("ROOM EMPTY")) {
                return room;
            }
            return null;
    }

    public List<Guest> fillAll() throws IOException {
         configReadAndWriteFileGuest.writeToFile(PATH_GUEST, guestList);
        return guestList;
    }

    public void save(Guest guest) {
        guestList.add(guest);
    }


}
