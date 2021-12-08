package controller;

import model.Room;
import service.roomservice.IRoomService;
import service.roomservice.RoomServiceImpl;

import java.io.IOException;
import java.util.List;

public class RoomController {
    RoomServiceImpl roomService = new RoomServiceImpl();

    public List<Room> showListRoom() throws IOException {
        return roomService.fillAll();
    }

    public void createRoom(Room room) throws IOException {
        roomService.save(room);
    }

    public Room detailRoom(int id) {
        return roomService.findID(id);
    }

    public boolean deleteRoom(int id) throws IOException {
        return roomService.delete(id);
    }

    public void editRoom(int id, Room room) throws IOException {
            roomService.edit(id, room);

    }
    public int indexFindByRoomName(String roomName) {
        return roomService.indexFindByRoomName(roomName);
    }
    public int indexFindByRoomID(int RoomID) {
        return roomService.IndexFindById(RoomID);
    }


}
