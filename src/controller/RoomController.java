package controller;

import model.Room;
import service.roomservice.IRoomService;
import service.roomservice.RoomServiceImpl;

import java.io.IOException;
import java.util.List;

public class RoomController {
    IRoomService roomService = new RoomServiceImpl();

    public List<Room> showListRoom() throws IOException {
        return roomService.fillAll();
    }

    public void createRoom(Room room) {
        roomService.save(room);
    }

    public Room detailRoom(int id) {
        return roomService.findID(id);
    }

    public boolean deleteRoom(int id) {
        return roomService.delete(id);
    }

    public void editRoom(int id, Room room) {
            roomService.edit(id, room);

    }



}
