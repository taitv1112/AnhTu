package service.roomservice;

import config.ConfigReadAndWriteFile;
import io.Path;
import model.Room;

import java.io.IOException;
import java.util.List;

public class RoomServiceImpl implements IRoomService{
    public String PATH_ROOM = Path.PATH + "room.txt";
    ConfigReadAndWriteFile<Room> configReadAndWriteFile = new ConfigReadAndWriteFile<>();
    List<Room> roomList = configReadAndWriteFile.readFromFile(PATH_ROOM);


    @Override
    public List<Room> fillAll() throws IOException {
        configReadAndWriteFile.writeToFile(PATH_ROOM, roomList);
        return roomList;
    }

    @Override
    public void save(Room room) {
        roomList.add(room);
    }

    @Override
    public Room findID(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                return roomList.get(i);
            }
        }
        return null;
    }

    public int IndexFindById(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    public int indexFindByRoomName(String roomName) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomName.equals(roomList.get(i).getRoom_Name())) {
                return i;
            }
        }
        return -1;
    }



    @Override
    public boolean delete(int id) {
        if (findID(id) !=null) {
            roomList.remove(id -1);
            return true;
        }
        return false;
    }

    @Override
    public void edit(int id, Room room) {
        if (IndexFindById(id) >=0) {
            roomList.set(IndexFindById(id), room);
        }
    }

    @Override
    public void start_Time() {

    }



}
