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
    ConfigReadAndWriteFile<Guest> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Guest> guestList = configReadAndWriteFile.readFromFile(PATH_ROOM);


    public Room searchPrice(double min, double max, Room room) {
            if (room.getPrice() >= min && room.getPrice() <= max && room.getStatus().equals("ROOM EMPTY")) {
                return room;
            }
            return null;
    }

    public List<Guest> fillAll() throws IOException {
        return guestList;
    }

    public void save(Guest guest) throws IOException {
        guestList.add(guest);
        configReadAndWriteFile.writeToFile(PATH_GUEST,guestList);
    }
    public int findIndexByUserName(String userName) {
        for (int i = 0; i < guestList.size(); i++) {
            if (userName.equals(guestList.get(i).getGuest_Name())) {
                return i;
            }
        }
        return -1;
    }


}
