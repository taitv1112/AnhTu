package service.roomservice;

import model.Room;
import service.Service;

public interface IRoomService extends Service<Room> {

    public boolean delete(int id);

    public void edit(int id, Room room);

    public void start_Time();

}
