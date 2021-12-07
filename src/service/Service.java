package service;

import java.io.IOException;
import java.util.List;

public interface Service<T> {
    List<T> fillAll() throws IOException;

    void save(T t) throws IOException;

    T findID(int id);


}
