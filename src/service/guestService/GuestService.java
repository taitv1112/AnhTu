package service.guestService;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Guest;
import model.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuestService {

    public String PATH_GUEST = Path.PATH + "guest.txt";
    ConfigReadAndWriteFile<Guest> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Guest> guestList = configReadAndWriteFile.readFromFile(PATH_GUEST);

    public List<Guest> fillAll() throws IOException {
        configReadAndWriteFile.writeToFile(PATH_GUEST,guestList);
        return guestList;
    }

    public void save(Guest guest) throws IOException {
        guestList.add(guest);
        configReadAndWriteFile.writeToFile(PATH_GUEST,guestList);

    }
    public int findIndexByUserName(String guestName) {
        for (int i = 0; i < guestList.size(); i++) {
            if (guestName.equals(guestList.get(i).getGuest_Name())) {
                return i;
            }
        }
        return -1;
    }




}
