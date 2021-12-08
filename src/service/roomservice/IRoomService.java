package service.roomservice;

import model.Room;
import service.Service;

import java.io.IOException;

public interface IRoomService extends Service<Room> {

    public boolean delete(int id) throws IOException;

    public void edit(int id, Room room) throws IOException;

    public void start_Time();

}
